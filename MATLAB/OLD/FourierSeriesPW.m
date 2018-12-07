function [FTransform] = FourierSeriesPW(function1, function2, pieceLimit1, pieceLimit2, precision, plotInterval)
% Author : Satyajit Ghana
% Arguments:
%   function1 : The first function
%   function2 : The second function
%   pieceLimit1 : end limit of function1
%   pieceLimit2 : end limit of function2
%   precision : value of n in fourier transform
%   plotInterval !optional default: [0 pieceLimit2]: Interval to plot
%
% USAGE Exaxmple: FourierSeriesPW(@(x) x, @(x) (3-x/2, 2, 6, 50, 6, [0 20]))

    %% default arguments
    if nargin < 6
        plotInterval = [0 pieceLimit2];
    end
    
    %% initialize
    f1 = function1;
    f2 = function2;
    l1 = pieceLimit1;
    l2 = pieceLimit2;
    K = precision;
    timePeriod = l2;
    T = timePeriod;
    syms x;
    w = (2*pi)/T;
    n = 1:K;
    
    FOriginal = @(x) function1(mod(x, T)).*(0 <= mod(x, T) & mod(x, T) < l1) + function2(mod(x, T)).*(l1 <= mod(x, T) & mod(x, T) < l2);

    %% calculate the constants
    
    % a better version
    %a0 = (2/T)*integral(@(x) FOriginal(x), 0, T);
    % fill with zeros to improve performance
    %an = zeros(1, K);
    %bn = zeros(1, K);
    %for i = 1:K
    %    an(i) = (2/T)*integral(@(x) FOriginal(x).*cos(i.*w.*x), 0, T);
    %    bn(i) = (2/T)*integral(@(x) FOriginal(x).*sin(i.*w.*x), 0, T);
    %end
    
    % plain-old way
    a0 = (2/T)*(int(f1, x, 0, l1) + int(f2, x, l1, l2));
    an = (2/T)*(int(f1*cos(n*w*x), x, 0, l1) + int(f2*cos(n*w*x), l1, l2));
    bn = (2/T)*(int(f1*sin(n*w*x), x, 0, l1) + int(f2*sin(n*w*x), l1, l2));
    v1 = [a0 an bn];
    v2 = [1/2 cos(n*w*x) sin(n*w*x)];
    
    FTransform = v1.*v2;

    %% fourier series
    FTransform = vpa(simplify(sum(FTransform)));
        
    %% plot the actual function    
    fplot(FOriginal, plotInterval, 'LineWidth', 2);
    hold on;
    
    %% plot the series
    fplot(sym(FTransform), plotInterval, 'LineWidth', 2);
    grid on;
    
    legend({'$ $ Original Function', 'Fourier Series Function'}, 'Interpreter', 'latex', 'Location', 'best');
    title(strcat('$ $ Fourier Series for PieceWise Function for N = $ $', num2str(precision)), 'Interpreter', 'latex');

end

