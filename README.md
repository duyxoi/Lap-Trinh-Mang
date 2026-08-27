# Lap-Trinh-Mang

```bash
javac -d bin src/Main.java && java -cp bin Main 
```

Cú pháp đúng của javac là:
```bash
javac -d <thư_mục_đầu_ra> <file_java_đầu_vào>
```

##  TCP ByteStream

  1. Cách kết nối TCP:
  Client dùng new Socket() kết nối tới IP/Port 2206 của Server. Dùng hàm connect(..., 5000) và setSoTimeout(5000) để giới hạn thời gian chờ
  tối đa là 5 giây.
  2. Tại sao dùng Byte (byte[]):
  Vì mạng chỉ truyền được dữ liệu nhị phân (0 và 1). Đổi dữ liệu ra mảng byte là cách truyền tải thô, nguyên bản và nhanh nhất.
  3. Vai trò của luồng:
      • OutputStream (Luồng ra): Đường ống để Client gửi byte dữ liệu đi.
      • InputStream (Luồng vào): Đường ống để Client nhận byte dữ liệu về.
  4. Dữ liệu nhận về là gì:
  Một dãy byte thô, khi dịch ra ký tự (UTF-8) sẽ là một chuỗi các số cách nhau bởi dấu phẩy (Ví dụ: "1,3,9,19,33,20").


dlsakj
