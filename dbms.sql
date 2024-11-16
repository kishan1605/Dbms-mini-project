-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 16, 2024 at 08:44 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.1.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbms`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `salary_down` ()   BEGIN
   UPDATE mechanic SET salary=(salary-500);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sal_hike` ()   BEGIN
	UPDATE mechanic SET salary=(salary+500) ;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `Admin_id` int(10) NOT NULL DEFAULT 1024,
  `Admin_Name` varchar(50) NOT NULL,
  `Admin_email` varchar(50) NOT NULL,
  `Admin_Ph` varchar(12) NOT NULL,
  `A_Password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`Admin_id`, `Admin_Name`, `Admin_email`, `Admin_Ph`, `A_Password`) VALUES
(113, 'Psych', 'kishan12y@gmail.com', '9738470958', '123456789');

-- --------------------------------------------------------

--
-- Table structure for table `booking`
--

CREATE TABLE `booking` (
  `service_id` int(10) NOT NULL,
  `customer_id` int(10) NOT NULL,
  `car_make` varchar(50) NOT NULL,
  `car_model` varchar(50) NOT NULL,
  `car_no` varchar(15) NOT NULL,
  `date` date NOT NULL,
  `prob_des` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `booking`
--

INSERT INTO `booking` (`service_id`, `customer_id`, `car_make`, `car_model`, `car_no`, `date`, `prob_des`) VALUES
(1, 1, 'audi', 'a1', 'KA09WE3444', '2023-01-25', 'problem in brakes'),
(5, 1, 'audi', 'a1', 'KA09TX5678', '2023-01-25', 'problem in gear'),
(12, 1, 'wrrt', '8765', '8754', '2023-01-25', 'Brake issue');

--
-- Triggers `booking`
--
DELIMITER $$
CREATE TRIGGER `trigg1` AFTER INSERT ON `booking` FOR EACH ROW insert into booking2 VALUES(new.service_id, null,null,"Not Approved")
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `booking2`
--

CREATE TABLE `booking2` (
  `service_id` int(10) NOT NULL,
  `mechanic_id` int(10) DEFAULT NULL,
  `Bill_amount` int(10) DEFAULT NULL,
  `Status` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `booking2`
--

INSERT INTO `booking2` (`service_id`, `mechanic_id`, `Bill_amount`, `Status`) VALUES
(1, 101, 200, 'Done'),
(5, 102, 499, 'In progress'),
(12, 101, 123, 'In progress');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `customer_id` int(10) NOT NULL,
  `customer_name` varchar(50) NOT NULL,
  `customer_email` varchar(50) NOT NULL,
  `customer_phone` varchar(12) NOT NULL,
  `c_password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`customer_id`, `customer_name`, `customer_email`, `customer_phone`, `c_password`) VALUES
(1, 'kishan', 'kishh@gmail.com', '8888888888', 'dragon123'),
(2, 'john', 'jonn@yahoo.com', '9988776655', 'dragon123'),
(3, 'naina', 'new@gmail.com', '9876543210', '123143'),
(4, 'Lavith', 'lavith@gmail.com', '9481421716', 'lavith1617');

-- --------------------------------------------------------

--
-- Table structure for table `mechanic`
--

CREATE TABLE `mechanic` (
  `mechanic_id` int(10) NOT NULL,
  `mechanic_name` varchar(50) NOT NULL,
  `mechanic_phone` varchar(12) NOT NULL,
  `salary` int(10) NOT NULL,
  `doj` date NOT NULL,
  `skills` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `mechanic`
--

INSERT INTO `mechanic` (`mechanic_id`, `mechanic_name`, `mechanic_phone`, `salary`, `doj`, `skills`) VALUES
(101, 'prithvik', '8888888888', 12000, '2022-09-11', 'wheels,  brakes,engine'),
(102, 'sadist', '8888888899', 16000, '2022-07-11', 'painting'),
(103, 'vaish', '8982312455', 26000, '2022-05-16', 'suspension,engine');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`Admin_id`);

--
-- Indexes for table `booking`
--
ALTER TABLE `booking`
  ADD PRIMARY KEY (`service_id`),
  ADD KEY `fkybooking` (`customer_id`);

--
-- Indexes for table `booking2`
--
ALTER TABLE `booking2`
  ADD PRIMARY KEY (`service_id`),
  ADD KEY `fkybooking2` (`mechanic_id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`customer_id`,`customer_email`),
  ADD UNIQUE KEY `customer_email` (`customer_email`);

--
-- Indexes for table `mechanic`
--
ALTER TABLE `mechanic`
  ADD PRIMARY KEY (`mechanic_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `booking`
--
ALTER TABLE `booking`
  MODIFY `service_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `booking2`
--
ALTER TABLE `booking2`
  MODIFY `service_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `customer_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `booking`
--
ALTER TABLE `booking`
  ADD CONSTRAINT `fkybooking` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`);

--
-- Constraints for table `booking2`
--
ALTER TABLE `booking2`
  ADD CONSTRAINT `fkybooking2` FOREIGN KEY (`mechanic_id`) REFERENCES `mechanic` (`mechanic_id`),
  ADD CONSTRAINT `fkybooking22` FOREIGN KEY (`service_id`) REFERENCES `booking` (`service_id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
