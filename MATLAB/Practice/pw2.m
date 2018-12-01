f = @(x) 0.*(-2 <= x & x < 2) + 3.*(2 <= x & x < 6) + 0.*(6 <=x & x < 10)

x = linspace(-2, 10, 1000);
y = f(x);

ry = repmat(y, 1, 3);
rx = linspace(-14, 22, length(ry));

plot(rx, ry);