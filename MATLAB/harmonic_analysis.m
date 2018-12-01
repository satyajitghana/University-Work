function [a0, an, bn] = harmonic_analysis(x, y)
%HARMONIC_ANALYSIS Summary of this function goes here
%   Detailed explanation goes here
n = length(y);
y1 = y(1);
yn = y(n);

if y1==yn
    n = n - 1;
end

T = n;
omega = 2*pi/T;

a0 = 2 * mean(y);

a = zeros(1, n);
b = zeros(1, n);

f = a0/2;

syms X;

for i=1:2
    sum1 = 0;
    sum2 = 0;
    
    for k=1:n
        a(k) = y(k) * cosd(i * omega * x(k));
        b(k) = y(k) * sind(i * omega * x(k));
        sum1 = sum1 + a(k);
        sum2 = sum2 + b(k);
    end
    an(i) = 2 * (sum1/n);
    bn(i) = 2 * (sum2/n);

    f = f + an(i) * cos(i * omega * X) + bn(i) * sin(i * omega * X);
end
disp(f);
disp(a0);
disp(an)
disp(bn);
fplot(f, [0 10]);
end

