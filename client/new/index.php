<html>
	<head>
		<title>CityVis Bot Communication Server - No Humans Here!</title>
	</head>
	<body>
		<?php
			$output = shell_exec("java -jar C:/Users/Samuel/Desktop/YRS/YRSCityVis/CityVisServer.jar C:/Users/Samuel/Desktop/YRS/YRSCityVis/server/ " . $argv[1]);
			echo $output;
		?>
	</body>
</html>