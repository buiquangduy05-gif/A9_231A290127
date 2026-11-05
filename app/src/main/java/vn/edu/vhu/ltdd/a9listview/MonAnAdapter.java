package vn.edu.vhu.ltdd.a9listview;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class MonAnAdapter extends BaseAdapter {

    private static class ViewHolder {
        ImageView imgAnh;
        TextView tvTen, tvMoTa, tvGia;
    }

    private static final int GIA_NGUONG = 45000;

    private final Context context;
    private final List<MonAn> danhSach;
    private final LayoutInflater inflater;

    public MonAnAdapter(Context context, List<MonAn> danhSach) {
        this.context = context;
        this.danhSach = danhSach;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() { return danhSach.size(); }

    @Override
    public Object getItem(int position) { return danhSach.get(position); }

    @Override
    public long getItemId(int position) { return position; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_mon_an, parent, false);
            holder = new ViewHolder();
            holder.imgAnh = convertView.findViewById(R.id.imgAnh);
            holder.tvTen = convertView.findViewById(R.id.tvTen);
            holder.tvMoTa = convertView.findViewById(R.id.tvMoTa);
            holder.tvGia = convertView.findViewById(R.id.tvGia);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        MonAn mon = danhSach.get(position);
        holder.imgAnh.setImageResource(mon.getAnhResId());
        holder.tvTen.setText(mon.getTen());
        holder.tvMoTa.setText(mon.getMoTa());
        holder.tvGia.setText(MonAn.dinhDangGia(mon.getGia()));

        // NC2: Dòng có giá trên 45.000 đ thì nền đổi màu nhạt
        if (mon.getGia() > GIA_NGUONG) {
            convertView.setBackgroundColor(Color.parseColor("#FFF3CD")); // Nền vàng nhạt
        } else {
            convertView.setBackgroundColor(Color.TRANSPARENT); // Gán màu mặc định tránh dính màu khi cuộn
        }

        return convertView;
    }
}
