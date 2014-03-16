clear
clc
cd('sondes');
files = dir;
for i = 3:length(files)
    fileName = files(i,1).name
    data = csvread(fileName)
end
cd ..