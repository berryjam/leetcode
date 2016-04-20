package com.berryjam.alibaba;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
            if (coupon.getBouns(goodsPrice) < bouns) {
                result = coupon;
                bouns = coupon.getBouns(goodsPrice);
            }
        }

        return result;
    }


    public static void main(String[] args) {
        CouponRecommendation app = new CouponRecommendation();

        double googdsPrice = 201;
        Coupon manBaoYouCoupon = new ManBaoYouCoupon(100, 20);
        List<Coupon> coupons = new ArrayList<Coupon>();
        coupons.add(manBaoYouCoupon);
        app.setCoupons(coupons);
        app.getBestCoupon(googdsPrice);
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
    List<Map<Double, Double>> bounes = new ArrayList<Map<Double, Double>>(); // 按优惠顺序递增

    public HongBaoCoupon(List<Map<Double, Double>> bounes) {
        this.bounes = bounes;
    }

    @Override
    double getBouns(double goodsPrice) {
        for (int i = bounes.size() - 1; i >= 0; i--) {
            Map<Double, Double> map = bounes.get(i);
            double limit = map.keySet().iterator().next();
            if (goodsPrice >= limit) {
                return map.get(limit);
            }
        }
        return 0;
    }


}