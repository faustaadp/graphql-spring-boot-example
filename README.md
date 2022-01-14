# Deskripsi
Aplikasi sederhana untuk memantau tugas kuliah. Setiap mata kuliah (matkul) memiliki tugas-tugas, setiap mahasiswa bisa subscribe dan unsubscribe suatu matkul. Dengan aplikasi ini, kita bisa melihat tugas-tugas mahasiswa dari matkul-matkul yang disubscribe.

# Tugas
##### Atribut:
- kodeTugas [Kode dari tugas]
- nama [Nama dari tugas]
- matkul [Nama matkul dari tugas]
- deadline [Deadline tugas dengan format "YYYY-MM-DD"]

# Matkul
##### Atribut:
- kodeMatkul [Kode dari matkul]
- nama [Nama dari matkul]
- sks [Jumlah sks dari matkul]
- tugas [Kumpulan tugas-tugas dari matkul]

# Mahasiswa
##### Atribut:
- npm [Nomor Pokok Mahasiswa]
- nama [Nama dari mahasiswa]
- matkul [Kumpulan matkul-matkul yang disubscribe mahasiswa]

# Mutation
- `addTugas(kodeTugas: String, nama: String, kodeMatkul: String, deadline: String): Tugas` Menambahkan tugas
- `addMatkul(kodeMatkul: String, nama: String, sks: Int): Matkul` Menambahkan matkul
- `addMahasiswa(npm: Int, nama: String): Mahasiswa` Menambahkan mahasiswa
- `deleteTugas(kodeTugas: String) : Boolean` Menghapus tugas 
- `deleteMatkul(kodeMatkul: String) : Boolean` Menghapus matkul 
- `deleteMahasiswa(npm: Int) : Boolean` Menghapus Mahasiswa 
- `updateTugas(kodeTugas: String, nama: String, kodeMatkul: String, deadline: String): Tugas` Mengupdate tugas
- `updateMatkul(kodeMatkul: String, nama: String, sks: Int): Matkul` Mengupdate matkul
- `updateMahasiswa(npm: Int, nama: String): Mahasiswa` Mengupdate mahasiswa
- `subscribe(npm: Int, kodeMatkul: String): Mahasiswa` Subscribe / Unsubscribe mahasiswa ke suatu matkul

# Query
- `allDataMatkul: [Matkul]` Melihat seluruh matkul
- `allDataTugas: [Tugas]` Melihat seluruh tugas
- `allDataMahasiswa: [Mahasiswa]` Melihat seluruh mahasiswa
- `getTugasByKodeTugas(kodeTugas: String): Tugas` Melihat tugas berdasarkan kodeTugas
- `getMatkulByKodeMatkul(kodeMatkul: String) : Matkul` melihat matkul berdasar kodeMatkul
- `getMahasiswaByNpm(npm: Int) : Mahasiswa` Melihat mahasiswa berdasar npm
- `getTugasByNpm(npm: Int): [Tugas]` Melihat tugas tugas dari mahasiswa berdasarkan matkul-matkul yang sudah disubscribe