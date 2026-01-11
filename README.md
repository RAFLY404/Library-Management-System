# Library Management System

## Nama Aplikasi
Library Management System

---

## Deskripsi Singkat
Library Management System adalah aplikasi desktop berbasis JavaFX yang terintegrasi dengan database PostgreSQL.  
Aplikasi ini digunakan untuk mengelola data buku perpustakaan, seperti menambahkan buku, melihat daftar buku, mengubah status buku (dipinjam/dikembalikan), menghapus buku, serta melakukan pencarian buku berdasarkan judul atau penulis.

Aplikasi ini dibuat dengan menerapkan konsep Object-Oriented Programming (OOP) dan arsitektur MVC (Model–View–Controller).

---

## Cara Menjalankan Aplikasi
1. Pastikan PostgreSQL sudah terinstall dan berjalan
2. Buat database dengan nama `library_db`
3. Jalankan script SQL untuk membuat tabel `books`
4. Jalankan script seeder untuk mengisi data awal
5. Atur username dan password database pada file `DBConfig.java`
6. Tambahkan PostgreSQL JDBC Driver ke project
7. Jalankan file `MainApp.java`

---

## Daftar Class dan Fungsinya

1. **MainApp**  
   Sebagai entry point aplikasi JavaFX dan menampilkan tampilan utama.

2. **DBConfig**  
   Menyimpan konfigurasi database seperti URL, username, dan password.

3. **DBConnection**  
   Mengatur koneksi ke database PostgreSQL menggunakan JDBC.

4. **Book**  
   Class model yang merepresentasikan data buku (id, title, author, status).

5. **Status**  
   Enum yang merepresentasikan status buku (AVAILABLE, BORROWED).

6. **BookDAO**  
   Mengelola operasi database (CRUD) pada tabel buku.

7. **BookService**  
   Berisi logika bisnis dan menjadi penghubung antara DAO dan Controller.

8. **LibraryController**  
   Mengatur interaksi antara user interface dan data aplikasi.

9. **BookTableView**  
   Mengatur tampilan TableView untuk menampilkan data buku.

10. **BookForm**  
    Menyediakan form input untuk menambahkan buku baru.

11. **SearchBar**  
    Menyediakan fitur pencarian buku berdasarkan judul atau penulis.

12. **LayoutUtil**  
    Class utilitas untuk pengaturan layout dan padding UI.

13. **AlertUtil**  
    Class utilitas untuk menampilkan dialog peringatan atau error.

---

## Penjelasan Konsep OOP yang Dipakai

1. **Encapsulation**  
   Data pada class `Book` disembunyikan menggunakan access modifier private dan diakses melalui method getter.

2. **Abstraction**  
   Proses pengolahan data disederhanakan melalui class `BookService` dan `BookDAO` sehingga UI tidak berinteraksi langsung dengan database.

3. **Inheritance**  
   Konsep inheritance diterapkan secara implisit pada JavaFX, di mana class `MainApp` mewarisi class `Application`.

4. **Polymorphism**  
   Digunakan pada penggunaan komponen JavaFX seperti event handler dan method override pada lifecycle JavaFX.

---

## Teknologi yang Digunakan
- Java
- JavaFX
- PostgreSQL
- JDBC
- JavaFX CSS

---

## Author

Library Management System – Group Project LW01 Binus University - Rafly, Valeryan, Evan
