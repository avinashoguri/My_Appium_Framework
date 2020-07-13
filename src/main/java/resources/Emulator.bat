@ECHO OFF
CD C:\Users\Malempati Parvathi\AppData\Local\Android\Sdk\emulator
adb kill-server
adb start-server
emulator -avd AVIPie

