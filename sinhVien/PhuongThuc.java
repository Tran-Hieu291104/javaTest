package sinhVien;
import java.util.Scanner;

// Lớp phương thức sẽ khai báo và định nghĩa các phương thức
public class PhuongThuc {
    public void InputSV(SinhVien sv){
        Scanner sc = new Scanner(System.in);

        System.out.print("Vui long nhap ma sinh vien: ");
        sv.setMaSV(Integer.parseInt(sc.nextLine()));

        System.out.print("Vui long nhap ten: ");
        sv.setTenSV(sc.nextLine());

        System.out.print("Vui long nhap que quan: ");
        sv.setQueQuan(sc.nextLine());

        Diem dnew = new Diem();
        InputDiem(dnew);
        sv.setDiemSV(dnew);

        Lop lnew = new Lop();
        InputLop(lnew);
        sv.setLopSV(lnew);
    }

    public void OutputSV(SinhVien sv){
        System.out.println("Ma: " + sv.getMaSV());
        System.out.println("Ten: " + sv.getTenSV());
        System.out.println("Que quan: " + sv.getQueQuan());
        OutputDiem(sv.getDiemSV());
        OutputLop(sv.getLopSV());
//        vì phương thức getLopSV trả về 1 đối tượng thuộc class Lop nên nó có thể
//        tham chiếu tới các phương thức có trong class Lop
    }

//    các phương thức của 1 lớp
    public void InputLop(Lop lop){
        Scanner sc = new Scanner(System.in);
        System.out.print("Vui long nhap ma lop: ");
        lop.setMaKhoa(sc.nextLine());
        System.out.print("Vui long nhap ten lop: ");
        lop.setTen(sc.nextLine());
    }

    public void OutputLop(Lop lop){
        System.out.println("Ma lop: " + lop.getMaKhoa());
        System.out.println("Ten lop: " + lop.getTen());
    }

    public void InputDiem(Diem diem){
        Scanner sc = new Scanner(System.in);
        System.out.print("Vui long nhap diem qua trinh: ");
        diem.setDQT(Double.parseDouble(sc.nextLine()));
        System.out.print("Vui long nhap diem thi: ");
        diem.setDThi(Double.parseDouble(sc.nextLine()));
    }

    public void OutputDiem(Diem diem){
        System.out.println("Diem qua trinh: " + diem.getDQT());
        System.out.println("Diem thi: " + diem.getDThi());
    }

//    Các phương thức của danh sách
    public void InputDSSV(DanhSach ds){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong sinh vien: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++){
            System.out.println("Nhap thong tin sinh vien thu " + i);
            SinhVien tmp = new SinhVien();
            InputSV(tmp);
            ds.getMyListSV().add(tmp);
//            **
        }
    }

    public void OutputDSSV(DanhSach ds){
        for(int i = 0; i < ds.getMyListSV().size(); i++){
            System.out.println("Thong tin sinh vien thu " + i);
            OutputSV(ds.getMyListSV().get(i));
//            **
        }
    }

    public void TimKiemSV(DanhSach ds){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma sinh vien can tim: ");
        int ma = Integer.parseInt(sc.nextLine());
        SinhVien tmp = TimKiemSV(ds, ma);
        if(tmp != null){
            System.out.println("Thong tin sinh vien can tim");
            OutputSV(tmp);
        }
        else
            System.out.println("Khong tim thay sinh vien");
    }

    public SinhVien TimKiemSV(DanhSach ds, int ma){
        for(int i = 0; i < ds.getMyListSV().size(); i++){
            if(ma == ds.getMyListSV().get(i).getMaSV())
                return ds.getMyListSV().get(i);
        }
        return null;
    }

    //    Sửa sinh viên theo mã
    public void FixSV(SinhVien sv){
        Scanner sc = new Scanner(System.in);
        System.out.print("Vui long nhap ten: ");
        sv.setTenSV(sc.nextLine());
        System.out.print("Vui long nhap que quan: ");
        sv.setQueQuan(sc.nextLine());

        Diem dnew = new Diem();
        InputDiem(dnew);
        sv.setDiemSV(dnew);

        Lop lnew = new Lop();
        InputLop(lnew);
        sv.setLopSV(lnew);
    }

    public void FixSvInDS(DanhSach ds){ // Sửa sinh viên tìm theo mã trong ds
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma sinh vien can sua: ");
        int ma = Integer.parseInt(sc.nextLine());
        SinhVien tmp = TimKiemSV(ds, ma);
        if(tmp != null){
            FixSV(tmp);
            System.out.println("Da sua thanh cong");
        }
        else
            System.out.println("Khong tim thay sinh vien");
    }

    private double DTK(SinhVien sv){
        return (sv.getDiemSV().getDQT() * 0.3 + sv.getDiemSV().getDThi() * 0.7);
    }
    private void SX_DSSV(DanhSach ds){
        for(int i = 0; i < ds.getMyListSV().size(); i++){
            for(int j = 0; j < ds.getMyListSV().size() - 1 - i; j++){
                if(DTK(ds.getMyListSV().get(j + 1)) < DTK(ds.getMyListSV().get(j))){
                    SinhVien tmp = ds.getMyListSV().get(j + 1);
                    ds.getMyListSV().set((j + 1), ds.getMyListSV().get(j));
                    ds.getMyListSV().set(j, tmp);
//                    sắp xếp từ bé đến lớn
                }
            }
        }
    }

    public void OutputMax(DanhSach ds){ // sv diem thi max
        SinhVien SVMax = ds.getMyListSV().get(0);
        double max = ds.getMyListSV().get(0).getDiemSV().getDThi();
        for(int i = 1; i < ds.getMyListSV().size(); i++){
            if(max < ds.getMyListSV().get(i).getDiemSV().getDThi()){
                SVMax = ds.getMyListSV().get(i);
                max = SVMax.getDiemSV().getDThi();
            }
        }
        OutputSV(SVMax);
    }

    public void OutputTCDthi(DanhSach ds){ // DSSV diem thi >= 8.5
        for(int i = 0; i < ds.getMyListSV().size(); i++){
            if(8.5 <= ds.getMyListSV().get(i).getDiemSV().getDThi())
                OutputSV(ds.getMyListSV().get(i));
        }
    }

    public void OutputTCDQT(DanhSach ds){ // DSSV diem qt < 3.5
        for(int i = 0; i < ds.getMyListSV().size(); i++){
            if(3.5 > ds.getMyListSV().get(i).getDiemSV().getDThi())
                OutputSV(ds.getMyListSV().get(i));
        }
    }

    public void RemoveTCDthi(DanhSach ds){ // xoa sv dthi = 0
        int i = 0;
        while (i < ds.getMyListSV().size()){
            if (ds.getMyListSV().get(i).getDiemSV().getDThi() == 0)
                ds.getMyListSV().remove(i);
            else
                i++;
        }
    }

    public void OutputDSSVTimTheoLop(DanhSach ds){//Hien thi DSSB theo tên lớp cần tìm
        //Nhập lớp cần tìm
        System.out.println("Nhap Lop can tim : ");
        Lop lnew = new Lop();
        InputLop(lnew);
        //Tim theo tên lớp
        for (int i = 0; i < ds.getMyListSV().size(); i++) {
            if (lnew.getTen() == null ? ds.getMyListSV().get(i).getLopSV().getTen() == null :
                    lnew.getTen().equals(ds.getMyListSV().get(i).getLopSV().getTen())) {
//                phương thức equals dùng để so sánh 2 chuỗi; vd s1.equals(s2); nếu đúng trả về true
                OutputSV(ds.getMyListSV().get(i));
            }
        }
    }
}
