package com.company;

import java.util.ArrayList;
import java.util.List;

public class genRepayPlan {
    private static RepayPlan fPlan;
    public static void main(String[] args) {
        // write your code here
        List<RepayPlan> plans = getRepayPlan(0.125,12,30000);
        for(int i =0; i<plans.size();i++){
            RepayPlan plan = plans.get(i);
            System.out.println(plan.toString());
        }
        System.out.println("hello word");
    }

    public  static List<RepayPlan> getRepayPlan (double rate,int period, double amount){
        double rateMonth = rate/12;
        double tempRate = Math.pow((1+rateMonth),period);
        List<RepayPlan> plans = new ArrayList<RepayPlan>();
        double remainPrincipal = amount;
        for (int i =0; i<period;i++){
            double principal = round((amount*rateMonth*Math.pow((1+rateMonth),i))/(tempRate -1),2);
            if(i+1 ==period){
                principal = remainPrincipal;
            }
            double interest = round(remainPrincipal*rateMonth,2);
            double totalAmount = round(principal+interest,2);
            fPlan.setAmount(totalAmount);
            fPlan.setInterest(interest);
            fPlan.setNo(i+1);
            fPlan.setPrincipal(principal);
            plans.add(fPlan);
        }
        return plans;
    }
    private static double round (double amount, int digits){
        return (double)(Math.round(amount*10*digits)/(10*digits));
    }

    public class RepayPlan {
        private int no;
        private double amount;
        private double principal;
        private double interest;

        public int getNo() {
            return this.no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public void setPrincipal(double principal) {
            this.principal = principal;
        }

        public void setInterest(double interest) {
            this.interest = interest;
        }

        public double getAmount() {
            return this.amount;
        }

        public double getPrincipal() {
            return this.principal;
        }

        public double getInterest() {
            return this.interest;
        }

        public String toString() {
            return this.no + "-----" + this.principal + "-----" + this.interest;
        }
    }
}
