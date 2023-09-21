package com.example.finaljava6.Controller;

import com.example.finaljava6.Entity.PhieuGiaoHang;
import com.example.finaljava6.Service.PGHService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/phieugiaohang")
public class PGHController {
    @Autowired
    PGHService service;
    @GetMapping()
    public ResponseEntity<?> getAllVM(){
        return ResponseEntity.ok(service.getAllVM());
    }
    @GetMapping("/getall")
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "0",name = "page")Integer p){
        return  ResponseEntity.ok(service.getAll(p));
    }
    @PutMapping("/update")
    public  ResponseEntity<?> update(@RequestBody @Valid PhieuGiaoHang phieuGiaoHang, BindingResult result){
        PhieuGiaoHang phieuGiaoHang1 = new PhieuGiaoHang();
        phieuGiaoHang1.setNguoinhan(phieuGiaoHang.getNguoinhan());
        phieuGiaoHang1.setHoaDonGiao(phieuGiaoHang.getHoaDonGiao());
        phieuGiaoHang1.setPhigiaohang(phieuGiaoHang.getPhigiaohang());
        phieuGiaoHang1.setSdtnhan(phieuGiaoHang.getSdtnhan());
        if(result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            return ResponseEntity.ok(list);
        }
        else {
            service.update(phieuGiaoHang,phieuGiaoHang.getMaphieugiao());
            return ResponseEntity.ok("update thanh cong");
        }
    }
    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<?> delete(@PathVariable UUID id){
        if(service.delete(id)){
            return ResponseEntity.ok("Xoa thanh cong");
        }
        else {

            return ResponseEntity.ok("Xoa that bai");
        }
    }
    @GetMapping("/loc")
    public ResponseEntity<?> loc(){
        return ResponseEntity.ok(service.loc());
    }
    @GetMapping("/loc2")
    public ResponseEntity<?> loc2(){
        return ResponseEntity.ok(service.loc2());
    }
}
