# Deskripsi
Aplikasi sederhana untuk memantau tugas kuliah. Setiap mata kuliah (matkul) memiliki tugas-tugas, setiap mahasiswa bisa subscribe dan unsubscribe suatu matkul. Dengan aplikasi ini, kita bisa melihat tugas-tugas mahasiswa dari matkul-matkul yang disubscribe.

# Tugas
### Atribut:
- kodeTugas [Kode dari tugas]
- nama [Nama dari tugas]
- matkul [Nama matkul dari tugas]
- deadline [Deadline tugas dengan format "YYYY-MM-DD"]

# Matkul
### Atribut:
- kodeMatkul [Kode dari matkul]
- nama [Nama dari matkul]
- sks [Jumlah sks dari matkul]
- tugas [Kumpulan tugas-tugas dari matkul]

# Mahasiswa
### Atribut:
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

# Percobaan
### Menambahkan matkul PPL
```
mutation{
  addMatkul(kodeMatkul:"PPL", nama:"PPL", sks:6){
    kodeMatkul
    nama
    sks
  }
}
```
```
{
  "data": {
    "addMatkul": {
      "kodeMatkul": "PPL",
      "nama": "PPL",
      "sks": 6
    }
  }
}
```
### Menambahkan matkul Jarkom
```
mutation{
  addMatkul(kodeMatkul:"Jarkom", nama:"Jaringan Komputer", sks:4){
    kodeMatkul
    nama
    sks
  }
}
```
```
{
  "data": {
    "addMatkul": {
      "kodeMatkul": "Jarkom",
      "nama": "Jaringan Komputer",
      "sks": 4
    }
  }
}
```
### Menambahkan tugas TK-1 pada matkul PPL
```
mutation{
  addTugas(kodeTugas:"PPL-1", nama:"TK-1", kodeMatkul:"PPL", deadline:"2022-01-31"){
    kodeTugas
    nama
    matkul{
      kodeMatkul
      nama
      sks
    }
    deadline
  }
}
```
```
{
  "data": {
    "addTugas": {
      "kodeTugas": "PPL-1",
      "nama": "TK-1",
      "matkul": {
        "kodeMatkul": "PPL",
        "nama": "PPL",
        "sks": 6
      },
      "deadline": "2022-01-31"
    }
  }
}
```

### Menambahkan tugas TK-2 pada matkul PPL
```
mutation{
  addTugas(kodeTugas:"PPL-2", nama:"TK-2", kodeMatkul:"PPL", deadline:"2022-02-15"){
    kodeTugas
    nama
    matkul{
      kodeMatkul
      nama
      sks
    }
    deadline
  }
}
```
```
{
  "data": {
    "addTugas": {
      "kodeTugas": "PPL-2",
      "nama": "TK-2",
      "matkul": {
        "kodeMatkul": "PPL",
        "nama": "PPL",
        "sks": 6
      },
      "deadline": "2022-02-15"
    }
  }
}
```

### Menambahkan tugas PR-1 pada matkul Jarkom
```
mutation{
  addTugas(kodeTugas:"Jarkom-1", nama:"PR-1", kodeMatkul:"Jarkom", deadline:"2022-02-17"){
    kodeTugas
    nama
    matkul{
      kodeMatkul
      nama
      sks
    }
    deadline
  }
}
```

### Menambahkan mahasiswa Fausta
```
mutation{
  addMahasiswa(npm:1906285560, nama:"Fausta"){
    npm
    nama
  }
}
```
```
{
  "data": {
    "addMahasiswa": {
      "npm": 1906285560,
      "nama": "Fausta"
    }
  }
}
```

### Menambahkan mahasiswa Widardi
```
mutation{
  addMahasiswa(npm:19448686, nama:"Widardi"){
    npm
    nama
  }
}
```
```
{
  "data": {
    "addMahasiswa": {
      "npm": 19448686,
      "nama": "Widardi"
    }
  }
}
```
### Fausta subscribe matkul PPL
```
mutation{
  subscribe(npm:1906285560, kodeMatkul:"PPL"){
    nama
    npm
    matkul{
      sks
      nama
    }
  }
}
```
```
{
  "data": {
    "subscribe": {
      "nama": "Fausta",
      "npm": 1906285560,
      "matkul": [
        {
          "sks": 6,
          "nama": "PPL"
        }
      ]
    }
  }
}
```

### Widardi subscribe matkul Jarkom
```
mutation{
  subscribe(npm:19448686, kodeMatkul:"Jarkom"){
    nama
    npm
    matkul{
      sks
      nama
    }
  }
}
```
```
{
  "data": {
    "subscribe": {
      "nama": "Widardi",
      "npm": 19448686,
      "matkul": [
        {
          "sks": 4,
          "nama": "Jaringan Komputer"
        }
      ]
    }
  }
}
```
### Melihat seluruh matkul beserta tugasnya
```
{
  allDataMatkul{
    kodeMatkul
    nama
    sks
    tugas{
      nama
      kodeTugas
      deadline
    }
  }
}
```
```
{
  "data": {
    "allDataMatkul": [
      {
        "kodeMatkul": "PPL",
        "nama": "PPL",
        "sks": 6,
        "tugas": [
          {
            "nama": "TK-1",
            "kodeTugas": "PPL-1",
            "deadline": "2022-01-31"
          },
          {
            "nama": "TK-2",
            "kodeTugas": "PPL-2",
            "deadline": "2022-02-15"
          }
        ]
      },
      {
        "kodeMatkul": "Jarkom",
        "nama": "Jaringan Komputer",
        "sks": 4,
        "tugas": [
          {
            "nama": "PR-1",
            "kodeTugas": "Jarkom-1",
            "deadline": "2022-02-17"
          }
        ]
      }
    ]
  }
}
```
### Melihat daftar mahasiswa beserta matkul-matkul yang disubscribe
```
{
  allDataMahasiswa{
    nama
    npm
    matkul{
      kodeMatkul
      nama
      sks
    }	
  }
}
```
```
{
  "data": {
    "allDataMahasiswa": [
      {
        "nama": "Fausta",
        "npm": 1906285560,
        "matkul": [
          {
            "kodeMatkul": "PPL",
            "nama": "PPL",
            "sks": 6
          }
        ]
      },
      {
        "nama": "Widardi",
        "npm": 19448686,
        "matkul": [
          {
            "kodeMatkul": "Jarkom",
            "nama": "Jaringan Komputer",
            "sks": 4
          }
        ]
      }
    ]
  }
}
```

### Melihat tugas-tugas Fausta
```
{
  getTugasByNpm(npm:1906285560){
    nama
    matkul{
      nama
    }
    deadline
  }
}
```
```
  "data": {
    "getTugasByNpm": [
      {
        "nama": "TK-1",
        "matkul": {
          "nama": "PPL"
        },
        "deadline": "2022-01-31"
      },
      {
        "nama": "TK-2",
        "matkul": {
          "nama": "PPL"
        },
        "deadline": "2022-02-15"
      }
    ]
  }
}
```

### Melihat tugas-tugas Widardi
```
{
  getTugasByNpm(npm:19448686){
    nama
    matkul{
      nama
    }
    deadline
  }
}
```
```
{
  "data": {
    "getTugasByNpm": [
      {
        "nama": "PR-1",
        "matkul": {
          "nama": "Jaringan Komputer"
        },
        "deadline": "2022-02-17"
      }
    ]
  }
}
```

### Fausta subscribe matkul jarkom
```
mutation{
  subscribe(npm:1906285560, kodeMatkul:"Jarkom"){
    nama
    npm
    matkul{
      sks
      nama
    }
  }
}
```
```
{
  "data": {
    "subscribe": {
      "nama": "Fausta",
      "npm": 1906285560,
      "matkul": [
        {
          "sks": 6,
          "nama": "PPL"
        },
        {
          "sks": 4,
          "nama": "Jaringan Komputer"
        }
      ]
    }
  }
}
```

### Melihat tugas-tugas Fausta
```
{
  getTugasByNpm(npm:1906285560){
    nama
    matkul{
      nama
    }
    deadline
  }
}
```
```
{
  "data": {
    "getTugasByNpm": [
      {
        "nama": "TK-1",
        "matkul": {
          "nama": "PPL"
        },
        "deadline": "2022-01-31"
      },
      {
        "nama": "TK-2",
        "matkul": {
          "nama": "PPL"
        },
        "deadline": "2022-02-15"
      },
      {
        "nama": "PR-1",
        "matkul": {
          "nama": "Jaringan Komputer"
        },
        "deadline": "2022-02-17"
      }
    ]
  }
}
```

### Fausta unsubscribe matkul PPL
```
mutation{
  subscribe(npm:1906285560, kodeMatkul:"PPL"){
    nama
    npm
    matkul{
    	sks
      nama
    }
  }
}
```
```
{
  "data": {
    "subscribe": {
      "nama": "Fausta",
      "npm": 1906285560,
      "matkul": [
        {
          "sks": 4,
          "nama": "Jaringan Komputer"
        }
      ]
    }
  }
}
```

#Melihat tugas-tugas Fausta
```
{
  getTugasByNpm(npm:1906285560){
    nama
    matkul{
      nama
    }
    deadline
  }
}
```
```
{
  "data": {
    "getTugasByNpm": [
      {
        "nama": "PR-1",
        "matkul": {
          "nama": "Jaringan Komputer"
        },
        "deadline": "2022-02-17"
      }
    ]
  }
}
```

### Mengubah deadline PR-1 Jarkom menjadi 2022-02-22
```
mutation{
  updateTugas(kodeTugas:"Jarkom-1", deadline:"2022-02-22"){
    kodeTugas
    nama
    matkul{
      kodeMatkul
      nama
      sks
    }
    deadline
  }
}
```
```
{
  "data": {
    "updateTugas": {
      "kodeTugas": "Jarkom-1",
      "nama": "PR-1",
      "matkul": {
        "kodeMatkul": "Jarkom",
        "nama": "Jaringan Komputer",
        "sks": 4
      },
      "deadline": "2022-02-22"
    }
  }
}
```

### Melihat seluruh tugas beserta deadlinenya
```
{
  allDataTugas{
    nama
    deadline
  }
}
```
```
{
  "data": {
    "allDataTugas": [
      {
        "nama": "TK-1",
        "deadline": "2022-01-31"
      },
      {
        "nama": "TK-2",
        "deadline": "2022-02-15"
      },
      {
        "nama": "PR-1",
        "deadline": "2022-02-22"
      }
    ]
  }
}
```
