-- phpMyAdmin SQL Dump
-- version 2.11.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 27, 2014 at 01:19 PM
-- Server version: 5.0.51
-- PHP Version: 5.2.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

--
-- Database: `e-shopping`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `First` varchar(20) NOT NULL,
  `Last` varchar(20) NOT NULL,
  `DOB` date NOT NULL,
  `Email` varchar(200) NOT NULL,
  `Password` varchar(200) NOT NULL,
  `Profile` varchar(200) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`First`, `Last`, `DOB`, `Email`, `Password`, `Profile`) VALUES
('Akshay ', 'Gupta', '1992-01-29', 'admin@gmail.com', '1', 'userDoc/admin@gmail.com+mainImage.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

CREATE TABLE IF NOT EXISTS `cart` (
  `email` varchar(100) NOT NULL,
  `pcode` varchar(100) NOT NULL,
  `pquantity` varchar(10) NOT NULL,
  `added_on` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cart`
--

INSERT INTO `cart` (`email`, `pcode`, `pquantity`, `added_on`) VALUES
('akshay243601@gmail.com', '3371', '6', '2014-03-21 16:34:55'),
('akshay243601@gmail.com', '3380', '8', '2014-03-21 16:27:03'),
('akshay243601@gmail.com', '3379', '6', '2014-03-21 16:26:36'),
('s@gmail.com', '129', '9', '2014-03-14 14:19:16'),
('akshay243601@gmail.com', '129', '4', '2014-03-21 11:50:26'),
('akshay243601@gmail.com', '879', '1', '2014-03-21 11:50:12'),
('akshay243601@gmail.com', '1266', '1', '2014-03-21 11:50:12'),
('akshay243601@gmail.com', '0123', '1', '2014-03-21 11:50:12'),
('akshay243601@gmail.com', '487', '6', '2014-03-21 11:50:12');

-- --------------------------------------------------------

--
-- Table structure for table `categoryvisiblity`
--

CREATE TABLE IF NOT EXISTS `categoryvisiblity` (
  `categoryCode` int(11) NOT NULL auto_increment,
  `cName` varchar(15) NOT NULL,
  `pvisible` varchar(15) NOT NULL,
  UNIQUE KEY `categoryCode` (`categoryCode`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=328 ;

--
-- Dumping data for table `categoryvisiblity`
--

INSERT INTO `categoryvisiblity` (`categoryCode`, `cName`, `pvisible`) VALUES
(327, 'I-smart Phone', 'visible'),
(322, 'shoe', 'visible'),
(323, 'jacket', 'visible'),
(324, 'shirts', 'hidden'),
(325, 'jeans', 'visible'),
(326, 'watch', 'visible');

-- --------------------------------------------------------

--
-- Table structure for table `productinfo`
--

CREATE TABLE IF NOT EXISTS `productinfo` (
  `pcode` int(11) NOT NULL auto_increment,
  `pname` varchar(20) NOT NULL,
  `pcategory` varchar(20) NOT NULL,
  `pimage` varchar(200) NOT NULL,
  `pprice` int(10) NOT NULL,
  `quantity` varchar(10) NOT NULL,
  `pvisible` varchar(10) NOT NULL,
  `pdescription` varchar(1000) NOT NULL,
  `subCategory` varchar(100) NOT NULL,
  UNIQUE KEY `pcode` (`pcode`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3387 ;

--
-- Dumping data for table `productinfo`
--

INSERT INTO `productinfo` (`pcode`, `pname`, `pcategory`, `pimage`, `pprice`, `quantity`, `pvisible`, `pdescription`, `subCategory`) VALUES
(3385, 'Sparxs  shoes', 'shoe', 'ProductImage/shoe4.gif', 1299, '12', 'visible', 'Nice Product', 'Sport'),
(3369, 'shoes', 'shoe', 'ProductImage/shoe4.jpg', 12670, '12', 'visible', 'good Product', 'Canvas'),
(3370, 'Converse Casual Shoe', 'shoe', 'ProductImage/shoe4.gif', 1550, '10', 'hidden', 'good Product', 'Sport'),
(3371, 'Sports shirt ', 'shirts', 'ProductImage/jacket5.jpg', 1490, '10', 'visible', 'good Product', ''),
(3372, 'Puma Shirts', 'shirts', 'ProductImage/jacket10.jpg', 1573, '1', 'visible', ' good Product', ''),
(3373, 'Nike shirts', 'shirts', 'ProductImage/jacket4.jpg', 1200, '12', 'visible', 'good Product', ''),
(3374, 'John Player T-shirts', 'shirts', 'ProductImage/jacket8.jpg', 1350, '12', 'visible', 'good Product', ''),
(3375, 'winter Special jacke', 'shirts', 'ProductImage/jacket3.jpg', 1500, '10', 'visible', 'good Product', ''),
(3376, 'Sports Jackets', 'shirts', 'ProductImage/jacket1.jpg', 890, '1234', 'hidden', 'good Product', ''),
(3377, 'Nike Sports Jackets', 'jacket', 'ProductImage/jacket3.jpg', 9000, '10', 'visible', 'good Product', ''),
(3386, 'Puma Sports t-shirts', 'jacket', 'ProductImage/jacket2.jpg', 1234, '12', 'visible', 'ABC', 'Lather'),
(3379, 'Jackets', 'jacket', 'ProductImage/jacket7.jpg', 8900, '10', 'visible', 'good Product', ''),
(3380, 'Shoes', 'shoe', 'ProductImage/shoe5.jpg', 9000, '10', 'visible', 'Really An Awsm Product', ''),
(3381, 'Shirt', 'shirts', 'ProductImage/jacket9.jpg', 1542, '5', 'visible', 'Very Good Product', ''),
(3384, 'Sparxs', 'shoe', 'ProductImage/shoe4.gif', 1900, '23', 'visible', 'A', 'Canvas');

-- --------------------------------------------------------

--
-- Table structure for table `subcategory`
--

CREATE TABLE IF NOT EXISTS `subcategory` (
  `sCode` int(11) NOT NULL auto_increment,
  `sName` varchar(40) NOT NULL,
  `pvisible` varchar(40) NOT NULL,
  `categoryname` varchar(40) NOT NULL,
  UNIQUE KEY `sCode` (`sCode`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1242 ;

--
-- Dumping data for table `subcategory`
--

INSERT INTO `subcategory` (`sCode`, `sName`, `pvisible`, `categoryname`) VALUES
(1234, 'Canvas', 'visible', 'shoe'),
(1235, 'Sport', 'visible', 'shoe'),
(1236, 'Lather', 'visible', 'jacket'),
(1237, 'Couton', 'visible', 'jacket'),
(1238, 'Reebok', 'visible', 'watch'),
(1239, 'Puma', 'visible', 'jacket'),
(1240, 'Addidas', 'visible', 'shoe'),
(1241, 'smart HIFI ', 'visible', 'I-Phone');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `First` varchar(20) NOT NULL,
  `Last` varchar(20) NOT NULL,
  `DOB` date NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `Profile` varchar(2000) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`First`, `Last`, `DOB`, `Email`, `Password`, `Profile`) VALUES
('Akshay', 'Gupta', '2014-03-02', 'aksahy243601@gmail.com', '123', 'userDoc/aksahy243601@gmail.com+mainImage.jpg'),
('Akshay', 'Gupta', '1992-12-09', 'akshay243601@gmail.com', '1', 'userDoc/akshay243601@gmail.com+mainImage.jpg'),
('sahil', 'kumar', '1992-02-01', 's@gmail.com', '1', 'userDoc/s@gmail.com+aksahy243601@gmail.com+mainImage.jpg');
