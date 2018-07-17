# -*- coding: utf-8 -*-

from numpy import *

print(random.rand(4,4))

randMat = mat(random.rand(4,4))

print(randMat)
print(randMat.I)

invRandMat = randMat.I
print(randMat * invRandMat)


