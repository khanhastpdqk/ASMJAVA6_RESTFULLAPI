package com.example.finaljava6.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PhieuGiaoHang")
public class Phieugiaohang {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID maphieugiao;
    String nguoinhan;
    String sdtnhan;

}
