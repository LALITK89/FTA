set folder="%LOCALAPPDATA%\Google\Chrome\User Data\Default\Cache"

cd /d %folder%

for /F "delims=" %%i in ('dir /b') do (rmdir "%%i" /s/q || del "%%i" /s/q)

exit
