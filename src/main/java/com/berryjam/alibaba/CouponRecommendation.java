package com.berryjam.alibaba;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

import com.berryjam.alibaba.HongBaoCoupon.Item;

/**
 * @author huangjinkun.
 * @date 16/4/20
 * @time 下午6:43
 */
public class CouponRecommendation {
    List<Coupon> coupons = new ArrayList<Coupon>();

    /**
     * 根据商品总价返回最优的优惠券
     *
     * @param goodsPrice
     * @return
     */
    public Coupon getBestCoupon(double goodsPrice) {
        Coupon result = null;
        double bouns = 0;
        for (Coupon coupon : coupons) {
            if (coupon.getBouns(goodsPrice) > bouns) {
                result = coupon;
                bouns = coupon.getBouns(goodsPrice);
            }
        }

        return result;
    }


    public static void main(String[] args) {
        CouponRecommendation app = new CouponRecommendation();

        double goodsPrice = 201;
        Coupon manBaoYouCoupon = new ManBaoYouCoupon(100, 20);
        Item item1 = new Item(100, 20);
        Item item2 = new Item(200, 30);
        HongBaoCoupon hongBaoCoupon = new HongBaoCoupon(Lists.newArrayList(item1, item2));
        List<Coupon> coupons = new ArrayList<Coupon>();
        coupons.add(manBaoYouCoupon);
        coupons.add(hongBaoCoupon);
        app.setCoupons(coupons);
        System.out.println(app.getBestCoupon(goodsPrice).getBouns(goodsPrice));
    }

    public List<Coupon> getCoupons() {
        return coupons;
    }

    public void setCoupons(List<Coupon> coupons) {
        this.coupons = coupons;
    }
}

/**
 * 优惠券基类
 */
abstract class Coupon {
    /**
     * 根据商品总额计算出优惠额度
     *
     * @param goodsPrice 商品总价
     * @return
     */
    abstract double getBouns(double goodsPrice);
}

/**
 * 满包邮优惠券
 */
class ManBaoYouCoupon extends Coupon {
    double postage; // 邮费
    double limit; // 符合满包邮的最低商品总价

    public ManBaoYouCoupon(double limit, double postage) {
        this.limit = limit;
        this.postage = postage;
    }

    @Override
    double getBouns(double goodsPrice) {
        if (goodsPrice < limit) {
            return 0;
        } else {
            return postage;
        }
    }

    public double getPostage() {
        return postage;
    }

    public void setPostage(double postage) {
        this.postage = postage;
    }
}

/**
 * 红包优惠券
 */
class HongBaoCoupon extends Coupon {
    List<Item> items = new ArrayList<Item>(); // 按优惠顺序递增

    public HongBaoCoupon(List<Item> items) {
        this.items = items;
    }

    @Override
    double getBouns(double goodsPrice) {
        for (int i = items.size() - 1; i >= 0; i--) {
            if (goodsPrice >= items.get(i).limit) {
                return items.get(i).bouns;
            }
        }
        return 0;
    }


    static class Item {
        double limit; // 符合满减优惠的最低商品总价
        double bouns; // 优惠额度

        public Item(double limit, double bounds) {
            this.limit = limit;
            this.bouns = bounds;
        }

        public double getLimit() {
            return limit;
        }

        public void setLimit(double limit) {
            this.limit = limit;
        }

        public double getBouns() {
            return bouns;
        }

        public void setBouns(double bouns) {
            this.bouns = bouns;
        }
    }
}