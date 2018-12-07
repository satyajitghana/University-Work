%%
x = [0 60 120 180 240 300]
y = [1 1.4 1.9 1.7 1.5 1.2]

y.*cosd(x);
sum(y.*cosd(x))
y.*sind(x);
sum(y.*sind(x))
y.*cosd(2.*x);
sum(y.*cosd(2.*x))
y.*sind(2*x);
sum(y.*sind(2.*x))

%%
x = 0:60:300
x1 = x;
y = [1 1.4 1.9 1.7 1.5 1.2]
T = 2 * pi;
w = (2*pi)/T;

x = (pi/180)*x; 
syms t;

a0 = 2 * mean(y);
HS = a0/2;


h = 3; % number of harmonics
for i=1:h
    a(i) = 2 * mean(y.*cos(i*w*x));
    b(i) = 2 * mean(y.*sin(i*w*x));
    
    HS = HS + a(i) * cos(i*w*t) + b(i) * sin(i*w*t);
end
HS = vpa(HS, 4);

disp(HS);

fplot(HS, [0 length(x)])
hold on;
plot(x, y ,'*')
% t = linspace(x(1), x(end), 1000);
% y1 = eval(HS);
% plot(t, y1, 'r');

%%

hold off
x = [0 1 2 3 4 5]
y = [9 18 24 28 26 20]
harmonic_anal(x, y);
