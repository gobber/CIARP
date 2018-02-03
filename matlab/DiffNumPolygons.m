%   Author: Hanno Scharr, Institute of Bio- and Geosciences II,
%   Forschungszentrum J�lich
%   Contact: h.scharr@fz-juelich.de
%   Date: 02.02.2016 
%
% Copyright 2016, Forschungszentrum J�lich GmbH, 52425 J�lich, Germany
% 
%                          All Rights Reserved
% 
% All commercial use of this software, whether direct or indirect, is
% strictly prohibited including, without limitation, incorporation into in
% a commercial product, use in a commercial service, or production of other
% artifacts for commercial purposes.     
%
% Permission to use, copy, modify, and distribute this software and its
% documentation worldwide for research purposes solely is hereby granted 
% without fee, provided that the above copyright notice appears in all 
% copies and that both that copyright notice and this permission notice 
% appear in supporting documentation, and that the name of the author and 
% Forschungszentrum J�lich GmbH not be used in advertising or publicity 
% pertaining to distribution of the software without specific, written 
% prior permission of the author available under above contact.
% The author preserves the rights to request the deletion or cancel of 
% non-authorized advertising and /or publicity activities.
%
% For intentions of commercial use please contact 
%
% Forschungszentrum J�lich GmbH
% To the attention of Hans-Werner Klein
% Department Technology-Transfer
% Wilhelm-Johnen-Stra�e
% 52428 J�lich
% Germany
%
%
% THE AUTHOR AND FORSCHUNGSZENTRUM J�LICH GmbH DISCLAIM ALL WARRANTIES WITH 
% REGARD TO THIS SOFTWARE, INCLUDING ALL IMPLIED WARRANTIES OF 
% MERCHANTABILITY AND FITNESS FOR ANY PARTICULAR PURPOSE.  IN NO EVENT 
% SHALL THE AUTHOR OR FORSCHUNGSZENTRUM J�LICH GmbH BE LIABLE FOR ANY SPECIAL,  
% INDIRECT OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES WHATSOEVER RESULTING 
% FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN ACTION OF CONTRACT, 
% NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF OR IN CONNECTION WITH
% THE USE OR PERFORMANCE OF THIS SOFTWARE.  
%
% In case of arising software bugs neither the author nor Forschungszentrum 
% J�lich GmbH are obliged for bug fixes and other kinds of support.

function score = DiffNumPolygons(inPoly,gtPoly)
% inPoly: table with polygons to be evaluated. 
% gtPoly: ground truth polygons.
% score: difference between the number of polygons.

    NumIn = size(inPoly,1); % number of polygons in inTable
    NumGT = size(gtPoly,1); % number of polygons in gtTable 
    score = NumIn-NumGT;