-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 19, 2024 at 12:12 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `yvonne_imaniragena_osms`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `fname` varchar(255) DEFAULT NULL,
  `lname` varchar(255) DEFAULT NULL,
  `id_number` varchar(20) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `gender` varchar(21) DEFAULT NULL,
  `martial_status` varchar(26) DEFAULT NULL,
  `DoB` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`fname`, `lname`, `id_number`, `phone`, `gender`, `martial_status`, `DoB`, `email`, `password`) VALUES
('Yvonne', 'Imaniragena', '1200987', '0790232504', 'Female', 'sinle', '2000-12-12', 'yimaniragena@gmail.com', 'yvonne'),
('yvonne', 'imaniragena', '12009876', '0790232504', 'Female', 'single', '2001-12-12', 'yimaniragena@gmail.com', 'Imairagena@12'),
('niyigean', 'mike', '12345678', '12345678', 'Male', 'mmm', '2000-02-04', 'niyigenammije', 'mike'),
('mm', 'mm', '12345678', '123456789', 'Male', 'mm', '2000-02-05', 'mm', 'mm'),
('mmmm', 'mmmm', '123456789', '12345678', 'Male', 'mmmm', '2222-02-02', 'mmmm', 'mmmm'),
('mmmm', 'mmmm', '12345678', '1234567890', 'Male', '123456789', '2222-09-09', 'mmmm', 'mmmm'),
('mmmm', 'mmmm', '123456789', '123456789', 'Male', 'mmmm', '1111-09-09', 'mmmm', 'mmmm'),
('mmmm', 'mmmm', '2345678', '12345678', 'Male', 'mmmm', '3333-09-09', 'mmmm', 'mmmm'),
('mmmmm', 'mmmmm', '1234567', '1234567', 'Male', 'mmmmm', '9999-09-09', 'mmmmm', 'mmmmm'),
('mama', 'papa', '1234567778', '123456', 'Female', 'marriage', '1975-02-04', 'mama@gmail.com', 'mama'),
('Isaii', 'Byishimo', '12345', '07890', 'Male', 'single', '2000-02-02', 'isaii@gmail.com', 'isaii'),
('Blandine', 'Ineza', '1234567890', '0786534221', 'Female', 'single', '2003-02-04', 'ineza@gmail.com', 'ineza');

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `Orders_id` int(10) NOT NULL,
  `orderDate` varchar(220) DEFAULT NULL,
  `OrderStatus` varchar(220) DEFAULT NULL,
  `OrderProduct` varchar(220) DEFAULT NULL,
  `TotalPrice` varchar(220) DEFAULT NULL,
  `PaymentMethod` varchar(220) DEFAULT NULL,
  `Users_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`Orders_id`, `orderDate`, `OrderStatus`, `OrderProduct`, `TotalPrice`, `PaymentMethod`, `Users_id`) VALUES
(2, '09/4', 'rsfdghf', '3a54srudtyu', '5euxtycu', NULL, NULL),
(3, '12/12/2001', 'male', 'banana', '12400', NULL, NULL),
(5, '12-2-2003', 'single', 'mango', '2345', 'mompay', 2),
(6, '12-11-2006', '54vbhn', 'ibiryo', '3256', 'momopay', 2),
(13, '4-5-2000', 'hgdf3', 'ibiryo', '5256', 'momopay', 3),
(15, '4-3-2023', 'ROOM', 'Booking', '5000', 'Momopay', 2),
(16, '6-2-2023', 'Test', 'meat', '8000', 'credit card', 3);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `Product_id` int(10) NOT NULL,
  `Name` varchar(220) DEFAULT NULL,
  `Description` varchar(220) DEFAULT NULL,
  `Price` varchar(220) DEFAULT NULL,
  `StockQuantity` varchar(220) DEFAULT NULL,
  `ProductImage` varchar(220) DEFAULT NULL,
  `SuppierInformation` varchar(220) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`Product_id`, `Name`, `Description`, `Price`, `StockQuantity`, `ProductImage`, `SuppierInformation`) VALUES
(1, 'Cecile', 'Rubavu', '567', '956', 'yellow', 'yogati'),
(2, 'cecile', 'rwamagana', '6700', '675', 'yellow', 'sdfg'),
(10, 'Yvonne', 'Kigali', '5000', '23k', 'white', 'rice'),
(11, 'Egide', 'Kigali', '4000', '3k', 'red', 'Champaion'),
(12, 'Egide', 'Kigali', '4000', '3k', 'red', 'Champaion'),
(13, 'Ange', 'Gatsata', '2300', '3kg', 'blue', 'clothes'),
(14, 'Mizero', 'Nyagatare', '700', '8kg', 'black', 'hair'),
(15, '', '', '', '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `store`
--

CREATE TABLE `store` (
  `Store_id` int(10) NOT NULL,
  `Storename` varchar(220) DEFAULT NULL,
  `Storedescription` varchar(220) DEFAULT NULL,
  `Contactinformation` varchar(220) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `store`
--

INSERT INTO `store` (`Store_id`, `Storename`, `Storedescription`, `Contactinformation`) VALUES
(1, 'yyyyy', 'rrrrr', '078787878'),
(2, 'rtyertyuu', 'vcv gfghnjk', '7778'),
(4, 'yvonne', 'huye', '079023'),
(5, 'yvonne', 'huye', '079023'),
(7, 'Karuruma stock', 'Karuruma', '0790232504'),
(8, 'Yvonne\'stock', 'Kigali', '078534114'),
(10, '', '', ''),
(11, 'ange\'shop', 'kigali', '098765');

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `Transaction_id` int(10) NOT NULL,
  `PaymentAmount` varchar(220) DEFAULT NULL,
  `PaymentDate` varchar(220) DEFAULT NULL,
  `PaymentStatus` varchar(220) DEFAULT NULL,
  `Orders_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transaction`
--

INSERT INTO `transaction` (`Transaction_id`, `PaymentAmount`, `PaymentDate`, `PaymentStatus`, `Orders_id`) VALUES
(2, '600', '09/7/2008', 'payes', NULL),
(4, '3500', '2-4-2021', 'payee', NULL),
(5, '15000', '6-9-2009', 'pay', NULL),
(6, '200000', '8-5-2008', 'very interesting', NULL),
(7, '70000', '9-4-2003', 'test', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `Users_id` int(10) NOT NULL,
  `Username` varchar(220) DEFAULT NULL,
  `Password` varchar(220) DEFAULT NULL,
  `Email` varchar(220) DEFAULT NULL,
  `Phonenumber` varchar(220) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`Users_id`, `Username`, `Password`, `Email`, `Phonenumber`) VALUES
(2, 'titi', '5678', 'titi@gmail.com', NULL),
(3, 'Cecile', '875', 'cecile@gmail.com', NULL),
(4, 'ytifuv', '34567', 'dxyhk', NULL),
(7, 'sdfgh', 'sedrftgh', 'cfvghbj', NULL),
(8, 'Shadia', '342', 'shadia@gmail.com', NULL),
(9, 'Gatete', '87654', 'gatete@gmail.com', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`Orders_id`),
  ADD KEY `Users_id` (`Users_id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`Product_id`);

--
-- Indexes for table `store`
--
ALTER TABLE `store`
  ADD PRIMARY KEY (`Store_id`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`Transaction_id`),
  ADD KEY `Orders_id` (`Orders_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`Users_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `Orders_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `Product_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `store`
--
ALTER TABLE `store`
  MODIFY `Store_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `transaction`
--
ALTER TABLE `transaction`
  MODIFY `Transaction_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `Users_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`Users_id`) REFERENCES `users` (`Users_id`);

--
-- Constraints for table `transaction`
--
ALTER TABLE `transaction`
  ADD CONSTRAINT `transaction_ibfk_1` FOREIGN KEY (`Orders_id`) REFERENCES `orders` (`Orders_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
