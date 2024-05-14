package kot104.lab3.bt8

import java.util.Scanner

fun main() {
    val theMuonList = mutableListOf<TheMuon>()
    val scanner = Scanner(System.`in`)
    var tiepTuc: Boolean

    fun themTheMuon() {
        println("Nhap ma phieu muon: ")
        val maPhieuMuon = scanner.next()
        println("Nhap ngay muon (so nguyen duong): ")
        val ngayMuon = scanner.nextInt()
        println("Nhap han tra (so nguyen duong): ")
        val hanTra = scanner.nextInt()
        println("Nhap so hieu sach: ")
        val soHieuSach = scanner.next()

        println("Nhap thong tin sinh vien muon sach:")
        println("Ho ten: ")
        val hoTen = scanner.next()
        println("Tuoi: ")
        val tuoi = scanner.nextInt()
        println("Lop: ")
        val lop = scanner.next()

        val sinhVien = SinhVien(hoTen, tuoi, lop)
        val theMuon = TheMuon(maPhieuMuon, ngayMuon, hanTra, soHieuSach, sinhVien)
        theMuonList.add(theMuon)

        println("Them the muon thanh cong!")
    }

    fun xoaTheMuon() {
        println("Nhap ma phieu muon can xoa: ")
        val maPhieuMuon = scanner.next()
        val iterator = theMuonList.iterator()
        var found = false

        while (iterator.hasNext()) {
            val theMuon = iterator.next()
            if (theMuon.maPhieuMuon == maPhieuMuon) {
                iterator.remove()
                found = true
                println("Xoa the muon thanh cong!")
                break
            }
        }

        if (!found) {
            println("Khong tim thay the muon voi ma phieu muon: $maPhieuMuon")
        }
    }

    fun hienThiThongTinTheMuon() {
        if (theMuonList.isEmpty()) {
            println("Khong co the muon nao trong danh sach.")
        } else {
            println("Danh sach the muon:")
            theMuonList.forEach { theMuon ->
                println("Ma phieu muon: ${theMuon.maPhieuMuon}, Ngay muon: ${theMuon.ngayMuon}, Han tra: ${theMuon.hanTra}, So hieu sach: ${theMuon.soHieuSach}")
                println("Thong tin sinh vien: Ho ten: ${theMuon.sinhVien.hoTen}, Tuoi: ${theMuon.sinhVien.tuoi}, Lop: ${theMuon.sinhVien.lop}")
            }
        }
    }

    do {
        println("------------------------")
        println("Menu quan ly the muon")
        println("1. Them the muon")
        println("2. Hien thi danh sach the muon")
        println("3. Xoa the muon theo ma phieu muon")
        println("4. Thoat chuong trinh")

        print("Nhap lua chon cua ban: ")
        val options: Int = scanner.nextInt()

        when (options) {
            1 -> themTheMuon()
            2 -> hienThiThongTinTheMuon()
            3 -> xoaTheMuon()
            4 -> {
                println("Ket thuc chuong trinh")
                tiepTuc = false
                break
            }
            else -> {
                println("Nhap sai, vui long nhap lai")
            }
        }

        if (options != 4) {
            print("Ban co muon chon tiep lua chon tren menu? (c/k) ")
            val s = scanner.next()
            tiepTuc = s.equals("c", ignoreCase = true)
        } else {
            tiepTuc = false
        }
    } while (tiepTuc)
}