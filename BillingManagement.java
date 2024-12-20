import java.util.Scanner;
import java.util.ArrayList;
class Billing {
    private double amount;
    private String date;
    private String type;
    private String remark;

    public Billing(double amount, String date, String type, String remark) {
        this.amount = amount;
        this.date = date;
        this.type = type;
        this.remark = remark;
    }

    public double getAmount() {
        return amount;
    }
    public String getDate() {
        return date;
    }
    public String getType() {
        return type;
    }
    public String getRemark() {
        return remark;
    }
}
class Manage{
    private ArrayList<Billing> incomes;
    private ArrayList<Billing> outcomes;
    public Manage() {
        incomes = new ArrayList<>();
        outcomes = new ArrayList<>();
    }
    public void addIncome(double amount, String date, String type, String remark) {
        if(amount <= 0){
            System.out.println("收入金额必须为正数！");
            return;
        }
        Billing in = new Billing(amount, date, type, remark);
        incomes.add(in);
        System.out.println("新的收入记录完成！");
    }
    public  void addOutcome(double amount, String date, String type, String remark) {
        if(amount <= 0){
            System.out.println("支出金额必须为正数！");
            return;
        }
        Billing out = new Billing(amount, date, type, remark);
        outcomes.add(out);
        System.out.println("新的支出记录完成！");
    }
    //预算管理功能
    public void setBudget(double budget) {
        if (budget <= 0) {
            System.out.println("预算必须为正数！");
            return;
        }
        this.budget = budget;
        System.out.println("预算设置成功！");
    }

    public void viewBudget() {
        System.out.println("当前预算：" + budget);
    }
    //月度统计功能
    public void monthlySummary() {
        double totalIncome = 0;
        double totalOutcome = 0;
        for (Billing income : incomes) {
            totalIncome += income.getAmount();
        }
        for (Billing outcome : outcomes) {
            totalOutcome += outcome.getAmount();
        }
        System.out.println("本月收入总计：" + totalIncome);
        System.out.println("本月支出总计：" + totalOutcome);
        System.out.println("本月结余：" + (totalIncome - totalOutcome));
    }
}
public class BillingManagement {
    public static void main(String[] args) {
        Manage manage = new Manage();
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("记录收入请输入1：");
            System.out.println("记录收入请输入2：");
            System.out.println("请选择你要操作的内容：");
            int a = scanner.nextInt();
            if(a == 1){
                System.out.println("请输入收入金额：");
                double amount = scanner.nextDouble();
                System.out.println("请输入收入日期：");
                String date = scanner.next();
                System.out.println("请输入收入类别：");
                String type = scanner.next();
                System.out.println("请输入收入备注：");
                String remark = scanner.next();
            } else if (a ==2) {
                System.out.println("请输入支出金额：");
                double amount = scanner.nextDouble();
                System.out.println("请输入支出日期：");
                String date = scanner.next();
                System.out.println("请输入支出类别：");
                String type = scanner.next();
                System.out.println("请输入支出备注：");
                String remark = scanner.next();
            }
        }
    }
}