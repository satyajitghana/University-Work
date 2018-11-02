[X, Y, Z] = meshgrid(-4:0.1:4);
F = (Y.^3).*cos(X) + exp(7.*Y).*Z + (Z.^5).*X;
%scatter3(X(:), Y(:), Z(:), [], F(:));
%slice(X, Y, Z, F, [-4 4], [-4 4], [-4 4])
%contourslice(X, Y, Z, F, [-4 4], [-4 4], [-4 4], 100)
%isosurface(X, Y, Z, F, 1e-6)
%isosurface(X, Y, Z, F, 1e-5)
%isosurface(X, Y, Z, F, 1e-4)

[U, V, W] = gradient(F);
a = axes;
daspect([1 1 1]); view(3);
axis([-4 4 -4 4 -4 4]); hold on;
hSlice = slice(X, Y, Z, F, 4, 4, [-4 0]);
set(hSlice, 'EdgeColor', 'none', 'FaceColor', 'interp');
% add an isosurface
fv = isosurface(X, Y, Z, F, 0.3); hIsoSurf1 = patch(fv);
set(hIsoSurf1, 'CData', 0.3, 'FaceColor', 'flat', ...
    'EdgeColor', 'none');
% add stream slices
hStreamSlice = streamslice(X, Y, Z, U, V, W, ...
    4, 4, [-4 0], 0.5);
set(hStreamSlice, 'Color', 'w');
% add streamtubes
[sx, sy, sz] = meshgrid(0, [2 0 -2], [2 0 -2]);
hTubes = streamtube(X, Y, Z, U, V, W, sx, sy, sz);
set(hTubes, 'FaceColor', [0.8 1 1], 'EdgeColor', 'none');
% adjust lighting
camlight
camlight(-90, 0);
lighting gouraud