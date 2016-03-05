package com.berryjam;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangjinkun.
 * @date 16/3/5
 * @time 下午2:55
 */
public class InsertInterval {


    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<Interval>();

        int start = newInterval.start;
        int end = newInterval.end;

        Interval tmpInterval = new Interval();
        boolean needMerge = false;
        boolean done = false;


        for (int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (done) {
                result.add(interval);
                continue;
            }

            if (!needMerge) {
                if (start > interval.end) {
                    result.add(interval);
                    if (i == intervals.size() - 1) {
                        result.add(newInterval);
                    }
                    continue;
                } else {
                    if (start >= interval.start) { // start在区间内
                        tmpInterval.start = interval.start; // 需要合并，并要根据end来找出合并区间
                        needMerge = true;
                    } else {
                        tmpInterval.start = start; // 需要根据end来决定是否合并区间
                        if (end < interval.start) { // 不需要合并，并且区间处理完毕
                            tmpInterval.end = end;
                            result.add(tmpInterval);
                            needMerge = false;
                            done = true;
                            result.add(interval);
                            continue;
                        }
                        if (interval.start <= end && end <= interval.end) { // end在区间内，则合并到当前区间，区间处理完毕
                            tmpInterval.end = interval.end;
                            result.add(tmpInterval);
                            needMerge = false;
                            done = true;
                            continue;
                        } else { // end不在区间内，寻找下一个合并区间
                            if (i == intervals.size() - 1) { // 已经为最后区间，则合并
                                tmpInterval.end = end;
                                result.add(tmpInterval);
                                needMerge = false;
                                done = true;
                                continue;
                            } else {
                                needMerge = true;
                                done = false;
                                continue;
                            }
                        }
                    }
                }
            }


            if (!needMerge) {
                result.add(interval);
                continue;
            } else {
                if (end < interval.start) {
                    tmpInterval.end = end;
                    result.add(tmpInterval);
                    result.add(interval);
                    needMerge = false;
                    done = true;
                } else if (interval.start <= end && end <= interval.end) {
                    tmpInterval.end = interval.end;
                    result.add(tmpInterval);
                    needMerge = false;
                    done = true;
                } else {
                    if (i == intervals.size() - 1) {
                        tmpInterval.end = end;
                        result.add(tmpInterval);
                    }
                    continue;
                }
            }

        }

        if (intervals.size() == 0) {
            result.add(newInterval);
        }

        return result;
    }

    public static void main(String[] args) {
        InsertInterval insertInterval = new InsertInterval();
        List<Interval> list = new ArrayList<Interval>();

//        Interval i1 = new Interval(1, 2);
//        Interval i2 = new Interval(3, 5);
//        Interval i3 = new Interval(6, 7);
//        Interval i4 = new Interval(8, 10);
//        Interval i5 = new Interval(12, 16);
//        list.add(i1);
//        list.add(i2);
//        list.add(i3);
//        list.add(i4);
//        list.add(i5);
//        Interval newInterval = new Interval(4, 9);


//        Interval i11 = new Interval(1, 5);
//        list.add(i11);
//        Interval newInterval = new Interval(0, 6);

//        Interval i21 = new Interval(1, 5);
//        Interval i22 = new Interval(6, 8);
//        list.add(i21);
//        list.add(i22);
//        Interval newInterval = new Interval(0, 9);


        Interval i13 = new Interval(0, 1);
        Interval i14 = new Interval(5, 5);
        Interval i15 = new Interval(6, 7);
        Interval i16 = new Interval(9, 11);
        list.add(i13);
        list.add(i14);
        list.add(i15);
        list.add(i16);
        Interval newInterval = new Interval(12, 21);

        List<Interval> result = insertInterval.insert(list, newInterval);
        int a = 2;
    }


    static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
