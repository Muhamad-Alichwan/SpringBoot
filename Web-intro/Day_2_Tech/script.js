// document.querySelector('form').addEventListener('submit', getData);
function getData(event){
  
  // mencegah form dari perilaku defaultnya yaitu submit dan refresh otomatis
  // dengan menggunakan event.preventDefault(); kita mencegah hal tersebut
  // yang berguna untuk melihat data di console.
  // event.preventDefault();
  console.log(event);
  event.preventDefault();

  // Membuat variabel untuk mendapatkan element dari form
  let nama = document.getElementById("nama").value;
  let telepon = document.getElementById("telepon").value;
  let tanggallahir = document.getElementById("tanggallahir").value;
  let agama = document.getElementById("agama").value;

  // kenapa menggunakan querySelector dalam radio dan querySelectorAll dalam check box
  // karena querySelector berguna untuk memastikan hanya menampilkan satu yang di pilih dalam opsi radio
  // sedangkan querySelectorAll berguna untuk memastikan opsi apa saja yang di pilih
  let gender = document.querySelector('input[name="radioGrup"]:checked').value;

  // membuat array dari dokumen HTML yang memastikan input dari check box telah 
  // tercentang dan di masukan ke variabel arrayGenreMusik
  // jika dilakukan console log langsung akan menghasilkan object dari variabel arrayGenreMusik
  // yang di ceklist sebelumnya bukan menghasilkan value dari object
  let arrayGenreMusik = Array.from(document.querySelectorAll('input[name="checkBoxGrup"]:checked'));
  
  // selanjutnya array sebelumnya "untuk mendapatkan value" harus dilakukan mapping atau di 
  // lakukan pengecekan satu persatu objectnya dan di duplikasi ke variabel genreMusik
  let genreMusik = arrayGenreMusik.map(checkboxElement => checkboxElement.value);

  // Menampilkan value dan tipe data
  console.log(`Nama: ${nama}, Tipe data: ${typeof nama}`);
  console.log(`Telepon: ${telepon}, Tipe data: ${typeof telepon}`);
  console.log(`Tanggal Lahir: ${tanggallahir}, Tipe data: ${typeof tanggallahir}`);
  console.log(`Agama: ${agama}, Tipe data: ${typeof agama}`);
  console.log(`Gender: ${gender}, Tipe data: ${typeof gender}`);
  console.log(`Genre Musik: ${genreMusik}, Tipe data: ${typeof genreMusik}`);
}