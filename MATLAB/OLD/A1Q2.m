f1 = @(x) x;
l1 = 2;
f2 = @(x) 3 - x./2;
l2 = 6;
%disp(FourierSeriesPW(f1, f2, 2, 6, 20, [-24 24]))

PlotPiecewise(f1, f2, l1, l2, [-24 24]);