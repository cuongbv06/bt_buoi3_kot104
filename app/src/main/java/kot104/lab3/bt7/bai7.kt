package kot104.lab3.bt7

fun main() {
    val teachers = mutableListOf<CBGV>()
    var tiepTuc: Boolean

    do {
        println("------------------------")
        println("Menu quan ly GV")
        println("1. Them giao vien")
        println("2. Hien thi danh sach GV")
        println("3. Xoa GV")
        println("4. Cap nhat thong tin GV")
        println("5. Thoat chuong trinh")

        try {
            print("Nhap lua chon cua ban: ")
            val options: Int = readLine()!!.toInt()
            when (options) {
                1 -> {
                    // Them giao vien
                    print("Nhap ho ten: ")
                    val hoten = readLine()!!
                    print("Nhap tuoi: ")
                    val tuoi = readLine()?.toIntOrNull()
                    print("Nhap que quan: ")
                    val quequan = readLine()
                    print("Nhap ma so GV: ")
                    val msgv = readLine()!!
                    print("Nhap luong cung: ")
                    val luongcung = readLine()!!.toFloat()
                    print("Nhap luong thuong: ")
                    val lThuong = readLine()?.toFloatOrNull()
                    print("Nhap luong phat: ")
                    val lPhat = readLine()?.toFloatOrNull()

                    val gv = CBGV(hoten, tuoi, quequan, msgv, luongcung, lThuong, lPhat)
                    teachers.add(gv)
                    println("Them giao vien thanh cong!")
                }
                2 -> {
                    // Hien thi danh sach GV
                    println("Danh sach giao vien")
                    println("--------------------------")
                    if (teachers.isEmpty()) {
                        println("Khong co giao vien nao trong danh sach.")
                    } else {
                        for (gv in teachers) {
                            println(gv.getThongTin())
                        }
                    }
                }
                3 -> {
                    // Xoa giao vien
                    print("Nhap msgv can xoa: ")
                    val msgv = readLine()!!
                    val iterator = teachers.iterator()
                    var found = false
                    while (iterator.hasNext()) {
                        val gv = iterator.next()
                        if (gv.msgv == msgv) {
                            iterator.remove()
                            found = true
                            println("Xoa giao vien thanh cong!")
                            break
                        }
                    }
                    if (!found) {
                        println("Khong tim thay giao vien voi msgv: $msgv")
                    }
                }
                4 -> {
                    // Cap nhat thong tin GV
                    print("Nhap msgv can cap nhat: ")
                    val msgv = readLine()!!
                    val gv = teachers.find { it.msgv == msgv }
                    if (gv != null) {
                        print("Nhap ho ten moi (de trong neu khong doi): ")
                        val hoten = readLine()
                        if (!hoten.isNullOrBlank()) {
                            gv.hoten = hoten
                        }

                        print("Nhap tuoi moi (de trong neu khong doi): ")
                        val tuoi = readLine()?.toIntOrNull()
                        if (tuoi != null) {
                            gv.tuoi = tuoi
                        }

                        print("Nhap que quan moi (de trong neu khong doi): ")
                        val quequan = readLine()
                        if (!quequan.isNullOrBlank()) {
                            gv.quequan = quequan
                        }

                        print("Nhap luong cung moi (de trong neu khong doi): ")
                        val luongcung = readLine()?.toFloatOrNull()
                        if (luongcung != null) {
                            gv.luongcung = luongcung
                        }

                        print("Nhap luong thuong moi (de trong neu khong doi): ")
                        val lThuong = readLine()?.toFloatOrNull()
                        if (lThuong != null) {
                            gv.lThuong = lThuong
                        }

                        print("Nhap luong phat moi (de trong neu khong doi): ")
                        val lPhat = readLine()?.toFloatOrNull()
                        if (lPhat != null) {
                            gv.lPhat = lPhat
                        }

                        println("Cap nhat thong tin giao vien thanh cong!")
                    } else {
                        println("Khong tim thay giao vien voi msgv: $msgv")
                    }
                }
                5 -> {
                    // Thoat chuong trinh
                    println("Ket thuc chuong trinh")
                    tiepTuc = false
                    break
                }
                else -> {
                    println("Nhap sai, vui long nhap lai")
                }
            }
            if (options != 5) {
                print("Ban co muon chon tiep lua chon tren menu? (c/k) ")
                val s = readLine()
                tiepTuc = s.equals("c", ignoreCase = true)
            } else {
                tiepTuc = false
            }
        } catch (e: Exception) {
            println("Nhap sai, vui long nhap lai")
            tiepTuc = true
        }
    } while (tiepTuc)
}