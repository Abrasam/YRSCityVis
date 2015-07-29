<<<<<<< HEAD
start "" http://127.0.0.1:80/
php -S 127.0.0.1:80
=======
start "" http://127.0.0.1:6666
start cmd /c "ping 127.0.0.1:6666 && exit"
start "" cmd /c "echo PHP-Server-Boot-INIT&echo(&pause"
start "" cmd /c "echo Loaded - index should be loaded&echo(&pause"
php -S 127.0.0.1:6666
pause
>>>>>>> origin/development
