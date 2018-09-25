function [] = PlotPiecewise(function1, function2, pieceLimit1, pieceLimit2, plotInterval)
%PLOTPIECEWISE Plots the funtion1, and function2 piecewis
%   Author: Satyajit Ghana
%   USAGE: PlotPiecewise(@(x) x, @(x) 3-x./2, 2, 6, [0 12])
%   plotInterval is optional

    %% default arguments
if nargin < 5
    plotInterval = [0 pieceLimit2];
end

    %% initialize
    l1 = pieceLimit1;
    l2 = pieceLimit2;
    timePeriod = l2;
    T = timePeriod;
    
    %% function
    FOriginal = @(x) function1(mod(x, T)).*(0 <= mod(x, T) & mod(x, T) < l1) + function2(mod(x, T)).*(l1 <= mod(x, T) & mod(x, T) < l2);

    %% plot
    fplot(FOriginal, plotInterval, 'LineWidth', 2);
    title('$ $ PieceWise Function Plot', 'Interpreter', 'latex');
    legend({'$ $ Function'}, 'Interpreter', 'latex', 'Location', 'best');
    
end

