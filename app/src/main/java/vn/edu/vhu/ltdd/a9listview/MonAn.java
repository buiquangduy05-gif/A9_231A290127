package vn.edu.vhu.ltdd.a9listview;

public class MonAn {

    private String ten;
    private String moTa;
    private int gia;
    private int anhResId;

    public MonAn(String ten, String moTa, int gia, int anhResId) {
        this.ten = ten;
        this.moTa = moTa;
        this.gia = gia;
        this.anhResId = anhResId;
    }

    public String getTen() { return ten; }
    public String getMoTa() { return moTa; }
    public int getGia() { return gia; }
    public int getAnhResId() { return anhResId; }

    public void setTen(String ten) { this.ten = ten; }
    public void setMoTa(String moTa) { this.moTa = moTa; }
    public void setGia(int gia) { this.gia = gia; }

    public static String dinhDangGia(int gia) {
        String s = String.valueOf(gia);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && (s.length() - i) % 3 == 0) sb.append('.');
            sb.append(s.charAt(i));
        }
        return sb + " đ";
    }
}