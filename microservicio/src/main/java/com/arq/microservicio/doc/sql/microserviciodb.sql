-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 03-10-2024 a las 11:40:05
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `microserviciodb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `telefono` varchar(50) DEFAULT NULL,
  `genero` char(1) DEFAULT NULL,
  `identificacion` char(10) DEFAULT NULL,
  `estado` tinyint(1) DEFAULT 1,
  `fechaCreacion` datetime NOT NULL DEFAULT current_timestamp(),
  `fechaActualizacion` datetime DEFAULT NULL,
  `usuarioId` int(11) DEFAULT NULL
) ;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id`, `nombre`, `apellido`, `direccion`, `telefono`, `genero`, `identificacion`, `estado`, `fechaCreacion`, `fechaActualizacion`, `usuarioId`) VALUES
(1, 'Jose', 'Lema', 'Otavalo sn y principal', '098254785', 'M', '1715789257', 1, '2024-10-03 04:24:06', NULL, 1),
(2, 'Marianela', 'Montalvo', 'Amazonas y NNUU', '097548965', 'F', '1578942358', 1, '2024-10-03 04:24:06', NULL, 2),
(3, 'Juan', 'Osorio', 'josoario@gmail.com', '098874587', 'M', '1945782489', 1, '2024-10-03 04:24:06', NULL, 3),
(4, 'Freddy', 'Torres', 'San Fernando', '0995418834', 'M', '1717703969', 1, '2024-10-03 04:24:32', NULL, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuenta`
--

CREATE TABLE `cuenta` (
  `id` int(11) NOT NULL,
  `numero` varchar(50) NOT NULL,
  `estado` tinyint(1) DEFAULT 1,
  `montoInicial` decimal(15,2) NOT NULL,
  `fechaCreacion` datetime NOT NULL DEFAULT current_timestamp(),
  `fechaActualizacion` datetime DEFAULT NULL,
  `tipocuenta` int(11) DEFAULT NULL,
  `cliente` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `cuenta`
--

INSERT INTO `cuenta` (`id`, `numero`, `estado`, `montoInicial`, `fechaCreacion`, `fechaActualizacion`, `tipocuenta`, `cliente`) VALUES
(1, '478758', 1, 100.00, '2024-10-03 04:30:50', NULL, 1, 1),
(2, '225487', 1, 100.00, '2024-10-03 04:31:54', NULL, 2, 2),
(3, '495878', 1, 100.00, '2024-10-03 04:32:32', NULL, 1, 3),
(4, '496825', 1, 100.00, '2024-10-03 04:33:31', NULL, 1, 2),
(5, '496715', 1, 100.00, '2024-10-03 04:36:21', NULL, 1, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `movimiento`
--

CREATE TABLE `movimiento` (
  `id` int(11) NOT NULL,
  `fecha` date NOT NULL DEFAULT curdate(),
  `monto` decimal(15,2) NOT NULL,
  `saldoDisponible` decimal(15,2) NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  `tipomovimiento` int(11) DEFAULT NULL,
  `fechaHora` datetime NOT NULL DEFAULT current_timestamp(),
  `cuenta` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `movimiento`
--

INSERT INTO `movimiento` (`id`, `fecha`, `monto`, `saldoDisponible`, `descripcion`, `tipomovimiento`, `fechaHora`, `cuenta`) VALUES
(1, '2024-10-03', 100.00, 100.00, 'APERTUTA DE CUENTA', 2, '2024-10-03 04:30:50', 1),
(2, '2024-10-03', 100.00, 100.00, 'APERTUTA DE CUENTA', 2, '2024-10-03 04:31:54', 2),
(3, '2024-10-03', 100.00, 100.00, 'APERTUTA DE CUENTA', 2, '2024-10-03 04:32:32', 3),
(4, '2024-10-03', 100.00, 100.00, 'APERTUTA DE CUENTA', 2, '2024-10-03 04:33:31', 4),
(5, '2024-10-03', 100.00, 100.00, 'APERTUTA DE CUENTA', 2, '2024-10-03 04:36:21', 5),
(6, '2024-10-03', 2500.00, 2600.00, 'PAGO SUELDO', 2, '2024-10-03 04:38:04', 5),
(7, '2024-10-03', 450.00, 2150.00, 'PAGO PENSION ', 1, '2024-10-03 04:38:37', 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipocuenta`
--

CREATE TABLE `tipocuenta` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `estado` tinyint(1) DEFAULT 1,
  `fechaCreacion` datetime NOT NULL DEFAULT current_timestamp(),
  `fechaActualizacion` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `tipocuenta`
--

INSERT INTO `tipocuenta` (`id`, `nombre`, `estado`, `fechaCreacion`, `fechaActualizacion`) VALUES
(1, 'AHORRO', 1, '2024-10-03 04:25:24', NULL),
(2, 'CORRIENTE', 1, '2024-10-03 04:25:24', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipomovimiento`
--

CREATE TABLE `tipomovimiento` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `estado` tinyint(1) DEFAULT 1,
  `fechaCreacion` datetime NOT NULL DEFAULT current_timestamp(),
  `fechaActualizacion` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `tipomovimiento`
--

INSERT INTO `tipomovimiento` (`id`, `nombre`, `estado`, `fechaCreacion`, `fechaActualizacion`) VALUES
(1, 'DEBITO', 1, '2024-10-03 04:26:17', NULL),
(2, 'DEPOSITO', 1, '2024-10-03 04:26:17', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `estado` tinyint(1) DEFAULT 1,
  `fechaCreacion` datetime NOT NULL DEFAULT current_timestamp(),
  `fechaActualizacion` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `email`, `password`, `estado`, `fechaCreacion`, `fechaActualizacion`) VALUES
(1, 'jlema@gmail.com', 'ysa31SlWeJfSOEGz1zai3w==', 1, '2024-10-03 04:23:15', NULL),
(2, 'mmontalvo@gmail.com', '9CNoF3S3j6FE3qNbsMKmZg==', 1, '2024-10-03 04:23:16', NULL),
(3, 'josoario@gmail.com', 'Vlu0GQCt5ppPFRqRWY9zrQ==', 1, '2024-10-03 04:23:16', NULL),
(4, 'ftorres@gmail.com', 'ysa31SlWeJfSOEGz1zai3w==', 1, '2024-10-03 04:24:32', NULL);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `idxIdentificacion` (`identificacion`) USING BTREE,
  ADD KEY `usuarioId` (`usuarioId`);

--
-- Indices de la tabla `cuenta`
--
ALTER TABLE `cuenta`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `idxNumero` (`numero`) USING BTREE,
  ADD KEY `tipocuenta` (`tipocuenta`),
  ADD KEY `cliente` (`cliente`);

--
-- Indices de la tabla `movimiento`
--
ALTER TABLE `movimiento`
  ADD PRIMARY KEY (`id`),
  ADD KEY `tipomovimiento` (`tipomovimiento`),
  ADD KEY `cuenta` (`cuenta`);

--
-- Indices de la tabla `tipocuenta`
--
ALTER TABLE `tipocuenta`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tipomovimiento`
--
ALTER TABLE `tipomovimiento`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`) USING BTREE;

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `cuenta`
--
ALTER TABLE `cuenta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `movimiento`
--
ALTER TABLE `movimiento`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `tipocuenta`
--
ALTER TABLE `tipocuenta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tipomovimiento`
--
ALTER TABLE `tipomovimiento`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`usuarioId`) REFERENCES `usuario` (`id`);

--
-- Filtros para la tabla `cuenta`
--
ALTER TABLE `cuenta`
  ADD CONSTRAINT `cuenta_ibfk_1` FOREIGN KEY (`tipocuenta`) REFERENCES `tipocuenta` (`id`),
  ADD CONSTRAINT `cuenta_ibfk_2` FOREIGN KEY (`cliente`) REFERENCES `cliente` (`id`);

--
-- Filtros para la tabla `movimiento`
--
ALTER TABLE `movimiento`
  ADD CONSTRAINT `movimiento_ibfk_1` FOREIGN KEY (`tipomovimiento`) REFERENCES `tipomovimiento` (`id`),
  ADD CONSTRAINT `movimiento_ibfk_2` FOREIGN KEY (`cuenta`) REFERENCES `cuenta` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
