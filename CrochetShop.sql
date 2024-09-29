CREATE DATABASE CrochetShop Character Set UTF8 Collate utf8_vietnamese_ci;

USE CrochetShop;

-- Bảng Users: Lưu thông tin người dùng
CREATE TABLE Users (
    User_id INT AUTO_INCREMENT PRIMARY KEY,
    Username VARCHAR(50) NOT NULL UNIQUE,
    Password VARCHAR(255) NOT NULL,
    Email VARCHAR(100) NOT NULL UNIQUE,
    Full_name NVARCHAR(100),
    Phone_number VARCHAR(20),
    Address NVARCHAR(255),
    Role VARCHAR(20)
);

-- Bảng Categories: Lưu thông tin các danh mục sản phẩm
CREATE TABLE Categories (
    Category_id INT AUTO_INCREMENT PRIMARY KEY,
    Category_name NVARCHAR(100) NOT NULL UNIQUE,
    Description TEXT
);

-- Bảng Products: Lưu thông tin các sản phẩm
CREATE TABLE Products (
    Product_id INT AUTO_INCREMENT PRIMARY KEY,
    Product_name NVARCHAR(100) NOT NULL,
    Description TEXT,
    Price INT,
    Stock_quantity INT NOT NULL,
    Size NVARCHAR(15),
    Quality NVARCHAR(15),
    Material NVARCHAR(15),
    Color NVARCHAR(15),
    Image VARCHAR(50),
    Category_id INT,
    FOREIGN KEY (Category_id) REFERENCES Categories(Category_id)
);

-- Bảng Cart: Lưu thông tin giỏ hàng của người dùng
CREATE TABLE Cart (
    Cart_id INT AUTO_INCREMENT PRIMARY KEY,
    User_id INT,
    FOREIGN KEY (User_id) REFERENCES Users(User_id)
);

-- Bảng CartItems: Lưu thông tin chi tiết các sản phẩm trong giỏ hàng
CREATE TABLE Cart_Items (
    Cart_item_id INT AUTO_INCREMENT PRIMARY KEY,
    Cart_id INT,
    Product_id INT,
    Quantity INT NOT NULL,
    FOREIGN KEY (Cart_id) REFERENCES Cart(Cart_id),
    FOREIGN KEY (Product_id) REFERENCES Products(Product_id)
);

-- Bảng Orders: Lưu thông tin đơn hàng
CREATE TABLE Orders (
    Order_id INT AUTO_INCREMENT PRIMARY KEY,
    User_id INT,
    Order_date VARCHAR(15),
    Total INT,
    Shipping_address NVARCHAR(255),
    Status NVARCHAR(50),
    FOREIGN KEY (User_id) REFERENCES Users(User_id)
);

-- Bảng OrderDetails: Lưu chi tiết từng sản phẩm trong đơn hàng
CREATE TABLE Order_Details (
    Order_detail_id INT AUTO_INCREMENT PRIMARY KEY,
    Order_id INT,
    Product_id INT,
    Quantity INT NOT NULL,
    Unit_price INT,
    FOREIGN KEY (Order_id) REFERENCES Orders(Order_id),
    FOREIGN KEY (Product_id) REFERENCES Products(Product_id)
);

-- Bảng Reviews: Lưu đánh giá của người dùng về sản phẩm
CREATE TABLE Reviews (
    Review_id INT AUTO_INCREMENT PRIMARY KEY,
    Product_id INT,
    User_id INT,
    Rating INT CHECK (Rating >= 1 AND Rating <= 5),
    Comment TEXT,
    FOREIGN KEY (Product_id) REFERENCES Products(Product_id),
    FOREIGN KEY (User_id) REFERENCES Users(User_id)
);

INSERT INTO Categories (Category_name)
VALUES 
('Thú Bông'),
('Nón'),
('Túi'),
('Áo Len');

INSERT INTO Products (Product_name, Description, Price, Stock_quantity, Size, Quality, Material, Color, Image, Category_id)
VALUES 
('Trái tim nhỏ', 'móc len hình Trái tim nhỏ nhắn đáng yêu.', 100000, 40, 'Nhỏ', 'Tốt', 'Len', 'Đỏ', 'pattern1.jpg', 1),
('Combo thú bông', 'móc len thú bông nhiều món dễ thương.', 200000, 30, 'Nhỏ', 'Tốt', 'Len', 'Nhiều màu', 'pattern2.jpg', 1),
('Cinnamoroll', 'móc len Cinnamoroll handmade giống mô hình cực xịn xò.', 100000, 40, 'Nhỏ', 'Tốt', 'Len', 'Trắng', 'pattern3.jpg', 1),
('Combo dải ngân hà', 'móc len mặt trời mặt trăng nho nhỏ xinh xắn.', 300000, 20, 'Nhỏ', 'Tốt', 'Len', 'Vàng', 'pattern4.jpg', 1);

INSERT INTO Users (Username, Password, Email, Full_name, Phone_number, Address, Role)
VALUES 
('admin', 'admin123', 'CrochetShop@gmail.com', 'Quản Trị Viên', '0123456789', '140 Lê Trọng Tân, Phường Tây Thạnh, Quận Tân Phú, TP.HCM', 'Admin');

INSERT INTO Users (Username, Password, Email, Full_name, Phone_number, Address, Role)
VALUES 
('dai', 'dai123', 'daiunited1505@gmail.com', 'Nguyễn Võ Quốc Đại', '0916380675', '357 Lê Văn Lương, Phường Tân Quy, Quận 7, TP.HCM', 'User');

select * from Users;
select * from Cart;
select * from Cart_Items;
delete from Cart_Items where Quantity = 1;
INSERT INTO Products (Product_name, Description, Price, Stock_quantity, Size, Quality, Material, Color, Image, Category_id)
VALUES 
('Nón len xám', 'Nón len xám đơn giản, ấm áp và dễ phối đồ.', 100000, 40, 'Nhỏ', 'Thường', 'Len mỏng', 'Xám', 'hat1.jpg', 2),
('Nón len đỏ', 'Nón len đỏ nổi bật, giúp bạn tự tin trong mọi hoàn cảnh.', 110000, 35, 'Vừa', 'Thường', 'Len mỏng', 'Đỏ', 'hat2.jpg', 2),
('Nón len xanh dương', 'Nón len xanh dương nhẹ nhàng, mang lại cảm giác dễ chịu.', 125000, 45, 'Nhỏ', 'Tốt', 'Len sợi to', 'Xanh dương', 'hat3.jpg', 2),
('Nón len họa tiết', 'Nón len họa tiết độc đáo, phong cách và thời thượng.', 150000, 25, 'Lớn', 'Tốt', 'Len sợi to', 'Nhiều màu', 'hat4.jpg', 2);


INSERT INTO Products (Product_name, Description, Price, Stock_quantity, Size, Quality, Material, Color, Image, Category_id)
VALUES 
('Túi xách len nhỏ', 'Túi xách len nhỏ gọn, tiện dụng và phong cách.', 250000, 30, 'Nhỏ', 'Tốt', 'Len sợi to', 'Đen', 'bag1.jpg', 3),
('Túi len đi biển', 'Túi len rộng rãi, hoàn hảo cho chuyến đi biển của bạn.', 300000, 20, 'Lớn', 'Thường', 'Len mỏng', 'Trắng', 'bag2.jpg', 3),
('Túi len họa tiết', 'Túi len họa tiết độc đáo, nổi bật giữa đám đông.', 270000, 25, 'Vừa', 'Thường', 'Len mỏng', 'Nhiều màu', 'bag3.jpg', 3),
('Túi đeo chéo len', 'Túi đeo chéo tiện lợi, mang lại sự thoải mái cho người dùng.', 280000, 40, 'Vừa', 'Tốt', 'Len sợi to', 'Xanh lá', 'bag4.jpg', 3);


INSERT INTO Products (Product_name, Description, Price, Stock_quantity, Size, Quality, Material, Color, Image, Category_id)
VALUES 
('Áo len cổ tròn', 'Áo len cổ tròn cổ điển, ấm áp và dễ phối đồ.', 400000, 20, 'Vừa', 'Tốt', 'Len sợi to', 'Xám', 'sweater1.jpg', 4),
('Áo len cổ tim', 'Áo len cổ tim nhẹ nhàng, mang lại vẻ đẹp tinh tế.', 420000, 18, 'Vừa', 'Tốt', 'Len sợi to', 'Đỏ', 'sweater2.jpg', 4),
('Áo len dáng dài', 'Áo len dáng dài, ấm áp và thời thượng cho mùa đông.', 400000, 15, 'Lớn', 'Thường', 'Len mỏng', 'Xanh navy', 'sweater3.jpg', 4),
('Áo len họa tiết', 'Áo len họa tiết độc đáo, mang lại sự tự tin và nổi bật.', 380000, 22, 'Lớn', 'Thường', 'Len mỏng', 'Nhiều màu', 'sweater4.jpg', 4);

