create database day11;

USE day11;


-- Table Agama
CREATE TABLE Agama (
Id SERIAL primary key not null,
Kode_Agama varchar,
Deskripsi varchar(20)
);

insert into Agama (Kode_Agama, Deskripsi) 
values ('A001','Islam'), ('A002','Kristen'),
('A003','Katolik'), ('A004','Hindu'), ('A005','Budha');

-- Table Jurusan
CREATE TABLE Jurusan (
Id SERIAL primary key not null,
Kode_Jurusan varchar,
Nama_Jurusan varchar(50),
Status_Jurusan varchar(20)
);

insert into Jurusan (Kode_Jurusan, Nama_Jurusan, Status_Jurusan) 
values ('J001','Teknik Informatika','Aktif'), ('J002','Management Informatika','Aktif'),
('J003','Sistem Informasi','Non Aktif'), ('J004','Sistem Komputer','Aktif'), ('J005','Komputer Akuntansi', 'Non Aktif');

--Table Type_Dosen
CREATE TABLE Type_Dosen (
Id SERIAL primary key not null,
Kode_TypeDosen varchar,
Deskripsi varchar(20)
);

insert into Type_Dosen (Kode_TypeDosen, Deskripsi) 
values ('T001','Tetap'), ('T002','Honorer'),
('T003','Expertise');

-- Table Dosen
CREATE TABLE Dosen (
Id SERIAL primary key not null,
Kode_Dosen varchar,
Nama_Dosen varchar(100),
Kode_Jurusan varchar,
Kode_Type_Dosen varchar
);

insert into Dosen (Kode_Dosen, Nama_Dosen, Kode_Jurusan, Kode_Type_Dosen) 
values ('D001', 'Prof. Dr. Retno Wahyuningsih', 'J001', 'T002'), ('D002', 'Prof. Roy M. Sutikno', 'J002', 'T001'),
('D003', 'Prof. Hendri A. Verburgh', 'J003', 'T002'), ('D004', 'Prof. Risma Suparwata', 'J004', 'T002'), 
('D005', 'Prof. Amir Sjarifuddin Madjid, MM, MA', 'J005', 'T001');

-- Table Mahasiswa
CREATE TABLE Mahasiswa (
Id SERIAL primary key not null,
Kode_Mahasiswa varchar,
Nama_Mahasiswa varchar(50),
Alamat varchar(100),
Kode_Agama varchar,
Kode_Jurusan varchar
);

insert into Mahasiswa(Kode_Mahasiswa, Nama_Mahasiswa, Alamat, Kode_Agama, Kode_Jurusan)
values ('M001', 'Budi Gunawan', 'Jl. Mawar No 3 RT 05 Cicalengka, Bandung', 'A001', 'J001'), 
('M002', 'Rinto Raharjo', 'Jl. Kebagusan No. 33 RT04 RW06 Bandung', 'A002', 'J002'),
('M003', 'Asep Saepudin', 'Jl. Sumatera No. 12 RT 02, Ciamis', 'A001', 'J003'),
('M004', 'M. Hafif Isbullah', 'Jl. Jawa No 01 RT01 RW01, Jakarta Pusat', 'A001', 'J001'),
('M005', 'Cahyono', 'Jl. Niagara No. 54 RT01 RW09, Surabaya', 'A003', 'J002');

-- Table Ujian
CREATE TABLE Ujian (
Id SERIAL primary key not null,
Kode_Ujian varchar,
Nama_Ujian varchar(50),
Status_Ujian varchar
);

insert into Ujian(Kode_Ujian, Nama_Ujian, Status_Ujian)
values ('U001', 'Algoritma', 'Aktif'),
('U002', 'Aljabar', 'Aktif'),
('U003', 'Statistika', 'Non Aktif'),
('U004', 'Etika Profesi', 'Non Aktif'),
('U005', 'Bahasa Inggris', 'Aktif');

-- Table Nilai
CREATE TABLE Nilai (
Id SERIAL primary key not null,
Kode_Mahasiswa varchar,
Kode_Ujian varchar,
Nilai integer
);

insert into Nilai(Kode_Mahasiswa, Kode_Ujian, Nilai)
values ('M004','U001', 90),
('M001','U002', 80),
('M002','U003', 85),
('M004','U004', 95),
('M005','U005', 70);

-- Soal Nomor 1
alter table dosen alter column Nama_Dosen type varchar(200);

-- Soal Nomor 2
select m.kode_mahasiswa, m.nama_mahasiswa, j.nama_jurusan, a.deskripsi as Agama 
from mahasiswa as m 
join jurusan as j on m.kode_jurusan = j.kode_jurusan 
join agama as a on m.kode_agama = a.kode_agama 
where m.nama_mahasiswa like 'Budi%';

-- Soal Nomor 3
select m.nama_mahasiswa, j.nama_jurusan, j.status_jurusan 
from mahasiswa as m 
join jurusan as j on m.kode_jurusan = j.kode_jurusan 
where j.status_jurusan = 'Non Aktif';

-- Soal Nomor 4
select m.nama_mahasiswa, n.nilai, u.status_ujian 
from mahasiswa as m 
join nilai as n on m.kode_mahasiswa = n.kode_mahasiswa 
join ujian as u on u.kode_ujian = n.kode_ujian 
where n.nilai > 80 and u.status_ujian = 'Aktif'; 

-- Soal Nomor 5
select * from jurusan as j where j.nama_jurusan ilike '%sistem%';

-- Soal Nomor 6
select m.nama_mahasiswa
from mahasiswa as m
join nilai as  n on m.kode_mahasiswa = n.kode_mahasiswa
join ujian as  u on n.kode_ujian = u.kode_ujian
group by m.nama_mahasiswa 
having count(n.kode_ujian) > 1 ;

-- Soal Nomor 7
select m.kode_mahasiswa, m.nama_mahasiswa, j.nama_jurusan,
d.nama_dosen, j.status_jurusan, td.deskripsi 
from mahasiswa as m 
join jurusan as j on m.kode_jurusan = j.kode_jurusan 
join agama as a on m.kode_agama = a.kode_agama
join dosen as d on m.kode_jurusan = d.kode_jurusan 
join type_dosen as td on d.kode_type_dosen = kode_typedosen 
where m.kode_mahasiswa = 'M001';
--where j.status_jurusan = 'Aktif'
--order by m.kode_mahasiswa asc ;

-- Soal Nomor 8
create view dataBudi as
select m.kode_mahasiswa, m.nama_mahasiswa, j.nama_jurusan,
d.nama_dosen, j.status_jurusan, td.deskripsi 
from mahasiswa as m 
join jurusan as j on m.kode_jurusan = j.kode_jurusan 
join agama as a on m.kode_agama = a.kode_agama
join dosen as d on m.kode_jurusan = d.kode_jurusan 
join type_dosen as td on d.kode_type_dosen = kode_typedosen 
where m.kode_mahasiswa = 'M001'; 

-- use view
select * from dataBudi;

-- Soal Nomor 9
select m.kode_mahasiswa, m.nama_mahasiswa, n.nilai 
from mahasiswa as m
left join nilai as n on m.kode_mahasiswa = n.kode_mahasiswa
-- full join nilai as n on m.kode_mahasiswa = n.kode_mahasiswa
order by m.id asc;
