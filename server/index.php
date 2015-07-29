<html>
	<head>
		<title>CityVis Server - No Humans Here!</title>
	</head>
	<body>
		<?php
			echo "Fishies.";
			$output = shell_exec("java -jar C:/Users/Samuel/Code/YRS/YRSCityVis/server/CityVisServer.jar C:/Users/Samuel/Code/YRS/YRSCityVis/server/ boroughmap");
			echo $output;
		?>
	</body>
</html>