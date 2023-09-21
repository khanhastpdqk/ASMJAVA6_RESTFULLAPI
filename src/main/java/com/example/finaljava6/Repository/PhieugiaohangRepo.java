package com.example.finaljava6.Repository;

import com.example.finaljava6.Entity.PhieuGiaoHang;
import com.example.finaljava6.Viewmodel.PhieugiaohangVM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface PhieugiaohangRepo extends JpaRepository<PhieuGiaoHang, UUID> {
    @Query(value = "select p.maphieugiao,p.nguoinhan,p.sdtnhan,p.phigiaohang,h.nguoilap,h.ghichu " +
            "from PhieuGiaoHang p join HoaDon h on p.HoaDonGiao = h.mahoadon",nativeQuery = true)
    List<PhieugiaohangVM> getALLPGHVM();
}
