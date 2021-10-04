import java.util.Scanner;

public class Level3Plus {
    static Scanner input = new Scanner(System.in);
    static String[][] s;
    public static void main(String[] args) {

        boolean exit = false;
        System.out.println("请确定本届学员总数：");
        s = new String[input.nextInt()][2];
        init();
        while (!exit){
            System.out.println("王中泰姐姐，请问您要进行什么操作(输入操作序号):");
            int select = input.nextInt();
            switch (select){
                case 1:
                    addStudent();
                    break;
                case 2:
                    deleteStudent();
                    break;
                case 3:
                    getStudent();
                    break;
                case 4:
                    reviseStudent();
                    break;
                case 5:
                    printAll();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("没有该功能");
            }
        }

    }

    static void init(){
        System.out.println("-------------------------------------------------");
        System.out.println("|\t\t\t\t欢迎来到学生管理系统\t\t\t\t|");
        System.out.println("|\t\t\t\t\t\t\t\tby 田宏志\t\t|");
        System.out.println("|                                               |");
        System.out.println("|\t操作列表:\t\t\t\t\t\t\t\t\t|");
        System.out.println("|\t\t\t1.添加学员\t\t\t\t\t\t\t|");
        System.out.println("|\t\t\t2.删除学员\t\t\t\t\t\t\t|");
        System.out.println("|\t\t\t3.查询学员\t\t\t\t\t\t\t|");
        System.out.println("|\t\t\t4.修改学员\t\t\t\t\t\t\t|");
        System.out.println("|\t\t\t5.打印所有学员信息（按学号排序）\t\t\t|");
        System.out.println("|\t\t\t6.退出系统\t\t\t\t\t\t\t|");
        System.out.println("|                                               |");
        System.out.println("-------------------------------------------------");
        System.out.println();
    }//开始界面

    static void list(){
        System.out.println("-------------------------------------------------");
        System.out.println("|                                               |");
        System.out.println("|\t操作列表:\t\t\t\t\t\t\t\t\t|");
        System.out.println("|\t\t\t1.添加学员\t\t\t\t\t\t\t|");
        System.out.println("|\t\t\t2.删除学员\t\t\t\t\t\t\t|");
        System.out.println("|\t\t\t3.查询学员\t\t\t\t\t\t\t|");
        System.out.println("|\t\t\t4.修改学员\t\t\t\t\t\t\t|");
        System.out.println("|\t\t\t5.打印所有学员信息（按学号排序）\t\t\t|");
        System.out.println("|\t\t\t6.退出系统\t\t\t\t\t\t\t|");
        System.out.println("|                                               |");
        System.out.println("-------------------------------------------------");
        System.out.println();
    }//操作列表

    static void addStudent(){
        System.out.println("输入学员学号：");
        String number = input.next();
        System.out.println("输入学员姓名：");
        String name = input.next();
        String[] student = {number,name};
        boolean isAdd = false;//是否成功添加
        for (int i = 0; i < s.length; i++) {
            if (s[i][0] == null && s[i][1] == null) {
                s[i] = student;
                isAdd = true;
                break;
            }
        }
        if (!isAdd){
            System.out.println("添加失败，已达到学员人数上限，无法继续添加");
        }else {
            System.out.println("添加成功");
        }
        System.out.println("是否继续添加？（yes/no）");
        String con = input.next();
        if (con.equals("yes")) {
            addStudent();
        }else if (con.equals("no")) {
            list();
        }else {
            System.out.println("没有该选项，默认选择no");
            list();
        }
    }//添加学员

    static void deleteStudent(){
        System.out.println("请输入要删除学员的学号：");
        String number = input.next();
        boolean isDelete = false;//是否删除成功
        for (int i = 0; i < s.length; i++) {
            if (s[i][0] != null && s[i][1] != null && s[i][0].equals(number)) {
                s[i][0] = null;
                s[i][1] = null;
                isDelete = true;
            }
        }
        if (isDelete) {
            System.out.println("删除成功");
        }else {
            System.out.println("该学号不存在");
        }
        isContinue();
        list();
    }//删除学员

    static void reviseStudent(){
        System.out.println("请输入要修改的学员学号");
        String number = input.next();
        System.out.println("请输入要修改的学员姓名");
        String name = input.next();
        boolean isFond = false;
        for (int i = 0; i < s.length; i++) {
            if (s[i][0] != null && s[i][1] != null && s[i][0].equals(number) && s[i][1].equals(name)) {
                System.out.println("学号要修改成？");
                s[i][0] = input.next();
                System.out.println("姓名要修改成？");
                s[i][1] = input.next();
                isFond = true;
                break;
            }
        }
        if (isFond) {
            System.out.println("修改成功");
        }else {
            System.out.println("不存在该学员");
        }
        isContinue();
        list();
    }//修改学员信息

    static void getStudent(){
        System.out.println("请输入要查询学员的学号：");
        String number = input.next();
        for (int i = 0; i < s.length; i++) {
            if (s[i][0] != null && s[i][1] != null && s[i][0].equals(number)) {
                System.out.println("该学员是:"+s[i][1]);
            }
        }
        isContinue();
        list();
    }//查询学员

    static void printAll(){
        boolean isEmpty = true;
        int validNum = 0;//有效数组长度
        for (int i = 0; i < s.length; i++) {
            if (s[i][0] != null && s[i][1] != null) {
                isEmpty = false;
                validNum++;
            }
        }
        if (isEmpty){
            System.out.println("数据库为空");
        }else {
            String[][] temp = new String[validNum][2];
            int j = 0;

            for (int i = 0; i < s.length; i++) {
                if (s[i][0] != null && s[i][1] != null) {
                    temp[j] =  s[i];
                    j++;
                }
            }

            for (int i = 0; i < temp.length; i++) {
                for (int k = 0; k < temp.length-1-i; k++) {
                    if (Integer.parseInt(temp[k][0])>Integer.parseInt(temp[k+1][0])) {
                        String[] str = temp[k];
                        temp[k] = temp[k+1];
                        temp[k+1] = str;
                    }
                }

            }

            System.out.println("学号\t\t\t\t姓名");
            for (int i = 0; i < temp.length; i++) {
                System.out.println(temp[i][0]+"\t\t\t\t"+temp[i][1]);
            }
        }

        isContinue();
        list();
    }//按学号排序并打印

    static void isContinue(){
        System.out.println("输入任意字符回车后继续....");
        input.next();
    }
}
