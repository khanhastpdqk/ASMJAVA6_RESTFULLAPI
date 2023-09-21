package com.example.finaljava6.Service;

import com.example.finaljava6.Entity.PhieuGiaoHang;
import com.example.finaljava6.Repository.PhieugiaohangRepo;
import com.example.finaljava6.Viewmodel.PhieugiaohangVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PGHService {
    @Autowired
    PhieugiaohangRepo repo;
    public List<PhieugiaohangVM> getAllVM(){
        return repo.getALLPGHVM();
    }
    public Page<PhieuGiaoHang> getAll(Integer p){
        Pageable pageable = PageRequest.of(p,5);
        return repo.findAll(pageable);
    }
    public Boolean update(PhieuGiaoHang phg, UUID id){
        PhieuGiaoHang phieuGiaoHang = repo.findById(id).get();
        if(phieuGiaoHang!= null){
            repo.save(phg);
            return true;
        }else{
            return false;
        }
    }
    public Boolean delete(UUID id){
        PhieuGiaoHang phieuGiaoHang = repo.findById(id).get();
        if(phieuGiaoHang!= null){
            repo.delete(phieuGiaoHang);
            return true;
        }else{
            return false;
        }
    }
    public List<PhieuGiaoHang> loc(){
        return repo.findAll().stream().filter(o->(o.getPhigiaohang()>10000&& o.getPhigiaohang()<3000000)).collect(Collectors.toList());
    }
    public PhieuGiaoHang loc2(){
        return repo.findAll().stream().max(Comparator.comparing(o->o.getPhigiaohang())).get();
    }

}
