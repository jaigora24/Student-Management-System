-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 13, 2022 at 07:28 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `studentmanagementsystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `name` varchar(50) NOT NULL,
  `entrynumber` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `contactnumber` varchar(15) NOT NULL,
  `homecity` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`name`, `entrynumber`, `email`, `contactnumber`, `homecity`) VALUES
('Divyankar Jha', '19bec022', '19bec022@smvdu.ac.in', '9876543210', 'Faridabad'),
('Ishu Sharma', '19bec031', '19bec031@smvdu.ac.in', '9876543210', 'Amritsar'),
('Jai Gora', '19bec033', '19bec033@smvdu.ac.in', '9876543210', 'Rohtak'),
('Manik Shama', '19bec046', '19bec046@smvdu.ac.in', '9876543210', 'Jammu'),
('Naishadh', '19bec050', '19bec050@smvdu.ac.in', '9876543210', 'New Delhi');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
