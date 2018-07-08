-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 08 Jul 2018 pada 07.09
-- Versi Server: 10.1.19-MariaDB
-- PHP Version: 5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `senyumdifabel`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `achievement`
--

CREATE TABLE `achievement` (
  `id` bigint(20) NOT NULL,
  `achivement` varchar(255) NOT NULL,
  `form` varchar(255) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `year` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `authorities`
--

CREATE TABLE `authorities` (
  `username` varchar(255) NOT NULL,
  `authority` varchar(255) DEFAULT NULL,
  `people_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `bookmark`
--

CREATE TABLE `bookmark` (
  `id` bigint(20) NOT NULL,
  `job_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `chat`
--

CREATE TABLE `chat` (
  `id` bigint(20) NOT NULL,
  `date` varchar(255) NOT NULL,
  `id_prev` bigint(20) NOT NULL,
  `message` varchar(255) NOT NULL,
  `sender` bigint(20) NOT NULL,
  `time` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `comment`
--

CREATE TABLE `comment` (
  `id` bigint(20) NOT NULL,
  `comment` varchar(255) NOT NULL,
  `date` varchar(255) NOT NULL,
  `time` varchar(255) NOT NULL,
  `timeline_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `company`
--

CREATE TABLE `company` (
  `description` varchar(255) NOT NULL,
  `user_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `contact`
--

CREATE TABLE `contact` (
  `id` bigint(20) NOT NULL,
  `contact` varchar(255) NOT NULL,
  `form` varchar(255) NOT NULL,
  `user_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `education`
--

CREATE TABLE `education` (
  `id` bigint(20) NOT NULL,
  `major` varchar(255) NOT NULL,
  `school` varchar(255) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `year` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `experience`
--

CREATE TABLE `experience` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `year` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `follower`
--

CREATE TABLE `follower` (
  `id` bigint(20) NOT NULL,
  `follower` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `following`
--

CREATE TABLE `following` (
  `id` bigint(20) NOT NULL,
  `follow` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `groups`
--

CREATE TABLE `groups` (
  `id` bigint(20) NOT NULL,
  `date` varchar(255) NOT NULL,
  `id_prev` bigint(20) NOT NULL,
  `message` varchar(255) NOT NULL,
  `sender` bigint(20) NOT NULL,
  `time` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Struktur dari tabel `job`
--

CREATE TABLE `job` (
  `job_id` bigint(20) NOT NULL,
  `company_id` bigint(20) NOT NULL,
  `date` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `time` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `likes`
--

CREATE TABLE `likes` (
  `id` bigint(20) NOT NULL,
  `timeline_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `notification`
--

CREATE TABLE `notification` (
  `id` bigint(20) NOT NULL,
  `data_id` bigint(20) NOT NULL,
  `data_id2` bigint(20) NOT NULL,
  `enable` bit(1) NOT NULL,
  `type` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `people`
--

CREATE TABLE `people` (
  `cv` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `prev_chat`
--

CREATE TABLE `prev_chat` (
  `id` bigint(20) NOT NULL,
  `date` varchar(255) NOT NULL,
  `id_chat` bigint(20) DEFAULT NULL,
  `peoplea` bigint(20) NOT NULL,
  `peopleb` bigint(20) NOT NULL,
  `prev_chat` varchar(255) DEFAULT NULL,
  `time` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `prev_group`
--

CREATE TABLE `prev_group` (
  `id_prev` bigint(20) NOT NULL,
  `date` varchar(255) NOT NULL,
  `group_name` varchar(255) NOT NULL,
  `id_chat` bigint(20) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `prev_chat` varchar(255) DEFAULT NULL,
  `time` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `proposal`
--

CREATE TABLE `proposal` (
  `id` bigint(20) NOT NULL,
  `company_id` bigint(20) NOT NULL,
  `job_id` bigint(20) NOT NULL,
  `status` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `skill`
--

CREATE TABLE `skill` (
  `id` bigint(20) NOT NULL,
  `skill` varchar(255) NOT NULL,
  `user_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `timeline`
--

CREATE TABLE `timeline` (
  `timeline_id` bigint(20) NOT NULL,
  `timeline_date` varchar(255) NOT NULL,
  `timeline_description` varchar(255) NOT NULL,
  `timeline_photo` varchar(255) DEFAULT NULL,
  `timeline_time` varchar(255) NOT NULL,
  `user_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `user_address` varchar(255) DEFAULT NULL,
  `user_contact` varchar(255) DEFAULT NULL,
  `user_email` varchar(255) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  `user_password` varchar(255) NOT NULL,
  `user_photo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `user_group`
--

CREATE TABLE `user_group` (
  `id` bigint(20) NOT NULL,
  `date` varchar(255) DEFAULT NULL,
  `id_prev` bigint(20) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `achievement`
--
ALTER TABLE `achievement`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKfakkqukhql1peebrcmd6np8ui` (`user_id`);

--
-- Indexes for table `authorities`
--
ALTER TABLE `authorities`
  ADD PRIMARY KEY (`username`),
  ADD KEY `FKp26iicny931eyc6a8hhq7ptw4` (`people_id`);

--
-- Indexes for table `bookmark`
--
ALTER TABLE `bookmark`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `chat`
--
ALTER TABLE `chat`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKppb6r5ywqak642xf0y48u75wf` (`timeline_id`);

--
-- Indexes for table `company`
--
ALTER TABLE `company`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `contact`
--
ALTER TABLE `contact`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK6nko5pwd1iwjhssxjqjwwmjjx` (`user_id`);

--
-- Indexes for table `education`
--
ALTER TABLE `education`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK2n87ydv5dpa2kh2op4n8oi0mt` (`user_id`);

--
-- Indexes for table `experience`
--
ALTER TABLE `experience`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKs7jiw34i89s38cd27tfrx52s6` (`user_id`);

--
-- Indexes for table `follower`
--
ALTER TABLE `follower`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `following`
--
ALTER TABLE `following`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `groups`
--
ALTER TABLE `groups`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `job`
--
ALTER TABLE `job`
  ADD PRIMARY KEY (`job_id`),
  ADD KEY `FK5q04favsasq8y70bsei7wv8fc` (`company_id`);

--
-- Indexes for table `likes`
--
ALTER TABLE `likes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKgvd0o14jw7qureyqyydpkv629` (`timeline_id`);

--
-- Indexes for table `notification`
--
ALTER TABLE `notification`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `people`
--
ALTER TABLE `people`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `prev_chat`
--
ALTER TABLE `prev_chat`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `prev_group`
--
ALTER TABLE `prev_group`
  ADD PRIMARY KEY (`id_prev`);

--
-- Indexes for table `proposal`
--
ALTER TABLE `proposal`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKmgyx3dx6icec474s183klg54d` (`company_id`),
  ADD KEY `FKdhe7bcq74m7gd59dyh9auqu1` (`job_id`),
  ADD KEY `FK45r5hlrbbp2xut7h22l2xf6cn` (`user_id`);

--
-- Indexes for table `skill`
--
ALTER TABLE `skill`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK6wfyhfqcvahluqnv4ldv1aiac` (`user_id`);

--
-- Indexes for table `timeline`
--
ALTER TABLE `timeline`
  ADD PRIMARY KEY (`timeline_id`),
  ADD KEY `FK16wx43e7vrd1ucqjf5f1x3vfy` (`user_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `user_group`
--
ALTER TABLE `user_group`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKe3tvfkvu5ykeaud9wo94ldns6` (`id_prev`),
  ADD KEY `FK6r9y11ajgp6fd0llo0nh3sidp` (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `achievement`
--
ALTER TABLE `achievement`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `bookmark`
--
ALTER TABLE `bookmark`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `chat`
--
ALTER TABLE `chat`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `comment`
--
ALTER TABLE `comment`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `contact`
--
ALTER TABLE `contact`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `education`
--
ALTER TABLE `education`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `experience`
--
ALTER TABLE `experience`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `follower`
--
ALTER TABLE `follower`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `following`
--
ALTER TABLE `following`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `groups`
--
ALTER TABLE `groups`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `job`
--
ALTER TABLE `job`
  MODIFY `job_id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `likes`
--
ALTER TABLE `likes`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `notification`
--
ALTER TABLE `notification`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `prev_group`
--
ALTER TABLE `prev_group`
  MODIFY `id_prev` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `proposal`
--
ALTER TABLE `proposal`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `skill`
--
ALTER TABLE `skill`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `achievement`
--
ALTER TABLE `achievement`
  ADD CONSTRAINT `FKfakkqukhql1peebrcmd6np8ui` FOREIGN KEY (`user_id`) REFERENCES `people` (`user_id`);

--
-- Ketidakleluasaan untuk tabel `authorities`
--
ALTER TABLE `authorities`
  ADD CONSTRAINT `FKp26iicny931eyc6a8hhq7ptw4` FOREIGN KEY (`people_id`) REFERENCES `people` (`user_id`);

--
-- Ketidakleluasaan untuk tabel `comment`
--
ALTER TABLE `comment`
  ADD CONSTRAINT `FKppb6r5ywqak642xf0y48u75wf` FOREIGN KEY (`timeline_id`) REFERENCES `timeline` (`timeline_id`);

--
-- Ketidakleluasaan untuk tabel `company`
--
ALTER TABLE `company`
  ADD CONSTRAINT `FKdy4v2yb46hefqicjpyj7b7e4s` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);

--
-- Ketidakleluasaan untuk tabel `contact`
--
ALTER TABLE `contact`
  ADD CONSTRAINT `FK6nko5pwd1iwjhssxjqjwwmjjx` FOREIGN KEY (`user_id`) REFERENCES `people` (`user_id`);

--
-- Ketidakleluasaan untuk tabel `education`
--
ALTER TABLE `education`
  ADD CONSTRAINT `FK2n87ydv5dpa2kh2op4n8oi0mt` FOREIGN KEY (`user_id`) REFERENCES `people` (`user_id`);

--
-- Ketidakleluasaan untuk tabel `experience`
--
ALTER TABLE `experience`
  ADD CONSTRAINT `FKs7jiw34i89s38cd27tfrx52s6` FOREIGN KEY (`user_id`) REFERENCES `people` (`user_id`);

--
-- Ketidakleluasaan untuk tabel `job`
--
ALTER TABLE `job`
  ADD CONSTRAINT `FK5q04favsasq8y70bsei7wv8fc` FOREIGN KEY (`company_id`) REFERENCES `company` (`user_id`);

--
-- Ketidakleluasaan untuk tabel `likes`
--
ALTER TABLE `likes`
  ADD CONSTRAINT `FKgvd0o14jw7qureyqyydpkv629` FOREIGN KEY (`timeline_id`) REFERENCES `timeline` (`timeline_id`);

--
-- Ketidakleluasaan untuk tabel `people`
--
ALTER TABLE `people`
  ADD CONSTRAINT `FKjmd5wsodlk0jyy131ko490tm6` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);

--
-- Ketidakleluasaan untuk tabel `proposal`
--
ALTER TABLE `proposal`
  ADD CONSTRAINT `FK45r5hlrbbp2xut7h22l2xf6cn` FOREIGN KEY (`user_id`) REFERENCES `people` (`user_id`),
  ADD CONSTRAINT `FKdhe7bcq74m7gd59dyh9auqu1` FOREIGN KEY (`job_id`) REFERENCES `proposal` (`id`),
  ADD CONSTRAINT `FKmgyx3dx6icec474s183klg54d` FOREIGN KEY (`company_id`) REFERENCES `company` (`user_id`);

--
-- Ketidakleluasaan untuk tabel `skill`
--
ALTER TABLE `skill`
  ADD CONSTRAINT `FK6wfyhfqcvahluqnv4ldv1aiac` FOREIGN KEY (`user_id`) REFERENCES `people` (`user_id`);

--
-- Ketidakleluasaan untuk tabel `timeline`
--
ALTER TABLE `timeline`
  ADD CONSTRAINT `FK16wx43e7vrd1ucqjf5f1x3vfy` FOREIGN KEY (`user_id`) REFERENCES `people` (`user_id`);

--
-- Ketidakleluasaan untuk tabel `user_group`
--
ALTER TABLE `user_group`
  ADD CONSTRAINT `FK6r9y11ajgp6fd0llo0nh3sidp` FOREIGN KEY (`user_id`) REFERENCES `people` (`user_id`),
  ADD CONSTRAINT `FKe3tvfkvu5ykeaud9wo94ldns6` FOREIGN KEY (`id_prev`) REFERENCES `prev_group` (`id_prev`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
