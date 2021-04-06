import java.util.Scanner;

public class HomeWork_06_04_21 {
    static String[] name = {"A", "B", "C", "D", "E", ""};
    static String[] id = {"1", "2", "3", "4", "5", ""};
    static String[] dOb = {"1/1", "2/2", "3/3", "4/4", "5/5", ""};
    static int[] mark = {8, 9, 10, 7, 8, 0, 0};
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
//        Sử dụng mảng và hàm để xây dựng ứng dụng quản lý sinh viên, mỗi sinh viên có các thông tin như: mã sinh viên, họ tên, ngày sinh, điểm thi.
//        1.     Hiển thị danh sách sinh viên
//        2.     Thêm một sinh viên mới
//        3.     Chỉnh sửa thông tin của một sinh viên khi biết mã sinh viên
//        4.     Xóa một sinh viên khỏi danh sách khi biết mã sinh viên
//        5.     Tìm sinh viên có điểm cao nhất
//        6.     Sắp xếp danh sách sinh viên theo điểm từ cao xuống thấp
        int choice = 1;
        while (choice != 0) {
            System.out.println("Chương trình quản lý sinh viên ^^");
            System.out.println("1. Hiển thị danh sách sinh viên");
            System.out.println("2. Thêm một sinh viên mới");
            System.out.println("3. Chỉnh sửa thông tin của một sinh viên khi biết mã sinh viên");
            System.out.println("4. Xóa một sinh viên khỏi danh sách khi biết mã sinh viên");
            System.out.println("5. Tìm sinh viên có điểm cao nhất");
            System.out.println("6. Sắp xếp danh sách sinh viên theo điểm từ cao xuống thấp");
            System.out.println("0. Exit");
            System.out.println("Lựa chọn của bạn: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Danh sách sinh viên: ");
                    studentList();
                    System.out.println("Bấm phím bất kì để tiếp tục");
                    sc.nextLine();
                    break;
                case 2:
                    //sc.nextLine();
                    System.out.println("Nhập tên sinh viên mới");
                    String newName = sc.nextLine();
                    System.out.println("Nhập ngày tháng năm sinh");
                    String newDOB = sc.nextLine();
                    System.out.println("Nhập diểm:");
                    int newMark = sc.nextInt();
                    newStudent(newName, newDOB, newMark);
                    System.out.println("Bấm phím bất kì để tiếp tục");
                    sc.nextLine();
                    break;
                case 3:
                    sc.nextLine();
                    int editID = 1;
                    do {
                        System.out.println("Nhập mã sinh viên muốn sửa:");
                        editID = sc.nextInt();
                    }
                    while (editID < 1 || editID > id.length);
                    editStudent(editID);
                    System.out.println("Bấm phím bất kì để tiếp tục");
                    sc.nextLine();
                    break;
                case 4:
                    sc.nextLine();
                    int deleteID = 1;
                    do {
                        System.out.println("Nhập mã ID muốn xoá");
                        deleteID = sc.nextInt();
                    }
                    while (deleteID < 1 || deleteID > id.length);
                    deleteStudent(deleteID);
                    System.out.println("Bấm phím bất kì để tiếp tục");
                    sc.nextLine();
                    break;
                case 5:
                    maxMark();
                    System.out.println("Bấm phím bất kì để tiếp tục");
                    sc.nextLine();
                    break;
                case 6:
                    sortMark();
                    System.out.println("Bấm phím bất kì để tiếp tục");
                    break;
            }
            sc.nextLine();
        }
    }

    static void studentList() {
        for (int i = 0; i < name.length; i++) {
            if (!id[i].equals("")) {
                System.out.println(id[i] + ". " + name[i]);
            }
        }
    }

    static void newStudent(String newName, String newDOB, int newMark) {
        name[5] = newName;
        dOb[5] = newDOB;
        mark[5] = newMark;
        id[5] = "6";
    }

    static void editStudent(int editID) {
        System.out.println("Bạn muốn sửa thông tin nào");
        System.out.println("1. Họ tên");
        System.out.println("2. Ngày tháng năm sinh");
        System.out.println("3. Điểm thi");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                sc.nextLine();
                System.out.println("Nhập họ tên mới");
                name[editID + 1] = sc.nextLine();
                break;
            case 2:
                sc.nextLine();
                System.out.println("Nhập ngày tháng năm sinh mới");
                dOb[editID + 1] = sc.nextLine();
                break;
            case 3:
                sc.nextLine();
                System.out.println("Nhập điểm thi mới");
                mark[editID + 1] = sc.nextInt();
                break;
        }
    }

    static void deleteStudent(int deleteID) {
        String temp = "";
        for (int i = deleteID - 1; i < id.length - 1; i++) {
            temp = id[i];
            id[i] = id[i + 1];
            id[i + 1] = temp;
            temp = name[i];
            name[i] = name[i + 1];
            name[i + 1] = temp;
            temp = dOb[i];
            dOb[i] = dOb[i + 1];
            dOb[i + 1] = temp;
        }
        id[id.length - 1] = "";
        name[name.length - 1] = "";
        dOb[dOb.length - 1] = "";
    }

    static void maxMark() {
        int max = mark[0];
        int index = 0;
        for (int i = 0 ; i < mark.length;i++) {
            if (max < mark[i]) {
                max = mark[i];
                index  = i;
            }
        }
        System.out.println("Sinh viên có điểm cao nhất là "+ name[index]);
    }

    static void sortMark(){
        String tempName = "";
        String tempID ="";
        int tempMark = 0;
        for (int i = 0 ; i < mark.length-1; i++){
            for  (int j = i+1; j < mark.length; j++){
                if (mark[i] < mark[j]) {
                    tempName = name[i];
                    name[i] = name[j];
                    name[j] = tempName;
                    tempID = id[i];
                    id[i] = id[j];
                    id[j] = tempID;
                    tempMark = mark[i];
                    mark[i] = mark[j];
                    mark[j] = tempMark;
                }
            }
        }
        System.out.println("Đã sắp xếp xong");
    }
}

