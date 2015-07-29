<html>
	<head>
		<title>CityVis Server - No Humans Here!</title>
	</head>
	<body>
		<?php
			$output = shell_exec("java -jar C:/Users/Samuel/Code/YRS/YRSCityVis/server/CityVisServer.jar C:/Users/Samuel/Code/YRS/YRSCityVis/server/ " . $argv[1]);
			echo $output;
		?>
	</body>
</html>