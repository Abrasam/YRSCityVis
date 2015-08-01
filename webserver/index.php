		<?php
			if ($_SERVER['QUERY_STRING'] == "crimedata") {
				$output = `java -jar C:/Users/Samuel/Code/YRS/YRSCityVis/CityVisServer.jar C:/Users/Samuel/Code/YRS/YRSCityVis/server/ crimedata 2>&1`;
				echo $output;
			} else if ($_SERVER['QUERY_STRING'] == "wardlocs") {
				$output = `java -jar C:/Users/Samuel/Code/YRS/YRSCityVis/CityVisServer.jar C:/Users/Samuel/Code/YRS/YRSCityVis/server/ wardlocs 2>&1`;
				echo $output;
			} else if ($_SERVER['QUERY_STRING'] == "wardlist") {
				$output = `java -jar C:/Users/Samuel/Code/YRS/YRSCityVis/CityVisServer.jar C:/Users/Samuel/Code/YRS/YRSCityVis/server/ wardlist 2>&1`;
				echo $output;
			} else if ($_SERVER['QUERY_STRING'] == "firedata") {
				$output = `java -jar C:/Users/Samuel/Code/YRS/YRSCityVis/CityVisServer.jar C:/Users/Samuel/Code/YRS/YRSCityVis/server/ firedata 2>&1`;
				echo $output;
			} else if ($_SERVER['QUERY_STRING'] == "pricedata") {
				$output = `java -jar C:/Users/Samuel/Code/YRS/YRSCityVis/CityVisServer.jar C:/Users/Samuel/Code/YRS/YRSCityVis/server/ pricedata 2>&1`;
				echo $output;
			} else if ($_SERVER['QUERY_STRING'] == "boroughmap") {
				$output = `java -jar C:/Users/Samuel/Code/YRS/YRSCityVis/CityVisServer.jar C:/Users/Samuel/Code/YRS/YRSCityVis/server/ boroughmap 2>&1`;
				echo $output;
			} else if ($_SERVER['QUERY_STRING'] == "updatecrimedata") {
				$output = `java -jar C:/Users/Samuel/Code/YRS/YRSCityVis/CityVisServer.jar C:/Users/Samuel/Code/YRS/YRSCityVis/server/ updatecrimedata 2>&1`;
				echo $output;
			} else if ($_SERVER['QUERY_STRING'] == "debug") {
				$output = `java -jar C:/Users/Samuel/Code/YRS/YRSCityVis/CityVisServer.jar C:/Users/Samuel/Code/YRS/YRSCityVis/server/ debug 2>&1`;
				echo $output;
			} else if ($_SERVER['QUERY_STRING'] == "fireimg") {
				$output = `java -jar C:/Users/Samuel/Code/YRS/YRSCityVis/CityVisServer.jar C:/Users/Samuel/Code/YRS/YRSCityVis/server/ fireimg 2>&1`;
				echo $output;
			} else if ($_SERVER['QUERY_STRING'] == "priceimg") {
				$output = `java -jar C:/Users/Samuel/Code/YRS/YRSCityVis/CityVisServer.jar C:/Users/Samuel/Code/YRS/YRSCityVis/server/ priceimg 2>&1`;
				echo $output;
			} else if ($_SERVER['QUERY_STRING'] == "mapimg") {
				$output = `java -jar C:/Users/Samuel/Code/YRS/YRSCityVis/CityVisServer.jar C:/Users/Samuel/Code/YRS/YRSCityVis/server/ mapimg 2>&1`;
				echo $output;
			}
		?>