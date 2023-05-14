# Spring_JPA
1. Spring Data JPA là gì? 
- JPA là một bộ đặc tả tiêu chuẩn của Java,trong đó mô tả các thao tác quản lý dữ liệu quan hệ sử dụng công nghệ ORM trong các ứng dụng sử dụng Java.

<img width="757" alt="Screenshot 2023-05-14 at 18 00 05" src="https://github.com/tuyetnga09/Spring_JPA/assets/108625115/d51f1319-0a21-494d-bf12-d59924d6b548">

- JPA cung cấp đầy đủ các công cụ cho phép thao tác với CSDL một cách đơn giản và nhanh chóng.
- JPA hoạt động như một cầu nối giữa các bảng/các mối quan hệ giữa các bảng trong cơ sở dữ liệu và các lớp/mối quan hệ giữa các đối tượng.

2. Lý do tại sao cần học Spring Data JPA
- No-code Repository
- Giảm thiểu tối đa boilerplate code
- Giải thích rõ hơn tại đây: https://thorben-janssen.com/what-is-spring-data-jpa-and-why-should-you-use-it/

3. Sử dụng Spring Data JPA trong Sring Boot như thế nào?
- Để sử dụng Spring Data JPA trong Spring boot chúng ta cần thêm spring-boot-starter-data-jpa dependency và jdbc driver tương ứng với database mà bạn đang sử dụng

<img width="829" alt="Screenshot 2023-05-14 at 18 07 34" src="https://github.com/tuyetnga09/Spring_JPA/assets/108625115/05fa851a-b40c-4486-a3b1-396ee3805c89">


- Tiếp theo, chúng ta cần cấu hình các thông qua kết nối database trong application.properties

<img width="900" alt="Screenshot 2023-05-14 at 18 08 26" src="https://github.com/tuyetnga09/Spring_JPA/assets/108625115/b50e9380-6df6-49ba-85d0-ad17122aad13">

==> Đây là project tôi sử dụng Spring Data JPA 

4. Hiển thị chi tiết sản phẩm 
<img width="994" alt="Screenshot 2023-05-07 at 16 57 43" src="https://user-images.githubusercontent.com/108625115/236670739-32fc3ea2-057a-44dd-a3d7-d4e1d7a5cebf.png">
5. Thêm sản phẩm 
<img width="1020" alt="Screenshot 2023-05-07 at 17 00 46" src="https://user-images.githubusercontent.com/108625115/236670852-5af646c8-2346-4bec-9f3e-6d6ae9362b70.png">
6. Cập nhật sản phẩm 
<img width="1028" alt="Screenshot 2023-05-07 at 17 01 43" src="https://user-images.githubusercontent.com/108625115/236670890-3344699a-8055-4350-8aab-9984658af251.png">
7. Xoá sản phẩm 
<img width="1023" alt="Screenshot 2023-05-07 at 17 02 22" src="https://user-images.githubusercontent.com/108625115/236670914-6b0f0dc0-3d05-417d-84c1-8a2e09d2db6e.png">
8. Hiển thị danh mục sản phẩm 
<img width="1010" alt="Screenshot 2023-05-07 at 17 03 09" src="https://user-images.githubusercontent.com/108625115/236670967-028fa730-c594-4bd4-80ba-d8845de7b163.png">
9. Thêm danh mục sản phẩm 
<img width="996" alt="Screenshot 2023-05-07 at 17 06 37" src="https://user-images.githubusercontent.com/108625115/236671145-1db4f9b2-dfcf-414d-b7d2-74c1d01ee99a.png">
10. Cập nhật danh mục sản phẩm 
<img width="1016" alt="Screenshot 2023-05-07 at 17 08 58" src="https://user-images.githubusercontent.com/108625115/236671244-8731e3db-c461-4e17-8c06-d20e4116e01f.png">
* Kiên thức lý thuyết: https://kungfutech.edu.vn/khoa-hoc/spring-boot, https://techmaster.vn/posts/37628/programmatic-transaction-management-in-spring
