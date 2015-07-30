<html>
	<head>
		<title>CityVis Bot Communication Server - No Humans Here!</title>
	</head>
	<body>
		<?php
			$output = shell_exec("java -jar C:/Users/Samuel/Desktop/YRS/YRSCityVis/CityVisServer.jar C:/Users/Samuel/Desktop/YRS/YRSCityVis/server/ " . $_SERVER['QUERY_STRING']);
			echo $output;
		?>
	</body>
</html>