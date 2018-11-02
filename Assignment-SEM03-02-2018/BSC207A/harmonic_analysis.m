function [HS, a0, a, b] = harmonic_analysis(x, y, nh)
%HARMONIC_ANALYSIS
% Author : Satyajit Ghana
% Computes the Harmonic function for a given set of values (x_i, y_i)
% Conditions for x : must be of period 2*pi, angles should be given in
% radians
%
% USAGE : x = linspace(0, 10*pi/6, 6)
% y = [1.98 1.30 1.05 1.30 -0.88 -0.25]
% HS = harmonic_analysis(x, y, 3)
%
% Extra Params : number of harmonics, default : 2

% handle the default parameter
if nargin < 2
    nh = 2;
end

T = 2 * pi;
w = (2*pi)/T;

%x = (pi/180)*x; 
syms t;

a0 = 2 * mean(y);
HS = a0/2;

h = nh; % number of harmonics
for i=1:h
    a(i) = 2 * mean(y.*cos(i*w*x));
    b(i) = 2 * mean(y.*sin(i*w*x));
    
    HS = HS + a(i) * cos(i*w*t) + b(i) * sin(i*w*t);
end

fplot(HS, [0 x(end)], 'LineWidth', 2)
hold on;
plot(x, y ,'*', 'LineWidth', 2)
grid on;

title('$ $ Harmonic Analysis', 'Interpreter', 'latex')
legend({'Harmonic Function', 'Data Points'}, 'Interpreter', 'latex')
xlabel('x $\rightarrow$', 'Interpreter', 'latex')
ylabel('f(x) $\rightarrow$', 'Interpreter', 'latex')

end

