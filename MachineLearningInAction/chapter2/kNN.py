# -*- coding: utf-8 -*-

from numpy import *
import operator

def createDataSet():
    group = array([[1.0, 1.1], [1.0, 1.0], [0,0], [0, 0.1]])
    labels = ['A', 'A', 'B', 'B']
    return group, labels

def classify0(inX, dataSet, labels, k):
    dataSetSize = dataSet.shape[0]
    print(dataSet.shape)
    diffMat = tile(inX, (dataSetSize,1)) - dataSet
    print("titleResult={0}".format(tile(inX, (dataSetSize,1))))
    print("dataSet={0}=".format(dataSet))
    print("diffMat={0}".format(diffMat))
    sqDiffMat = diffMat ** 2
    print("sqDiffMat={0}".format(sqDiffMat))
    sqDistances = sqDiffMat.sum(axis=1)
    print("sqDistances={0}".format(sqDistances))
    distances = sqDistances ** 0.5
    print("distances={0}".format(sqDistances))
    sortedDistIndicies = distances.argsort()
    print("sortedDistIndicies={0}".format(sortedDistIndicies))
    classCount = {}
    for i in range(k):
        voteIlabel = labels[sortedDistIndicies[i]]
        print("voteIlabel={0}".format(voteIlabel))
        classCount[voteIlabel] = classCount.get(voteIlabel, 0) + 1
        print("classCount[voteIlabel]={0}".format(classCount[voteIlabel]))

    print("classCount={0}".format(classCount))
    sortedClassCount = sorted(classCount.iteritems(), key=operator.itemgetter(1), reverse = True)    
    return sortedClassCount[0][0]

def file2matrix(filename):
    fr = open(filename)
    arrayOfLines = fr.readlines()
    numOfLines = len(arrayOfLines)
    returnMat = zeros((numOfLines, 3))
    classLabelVector = []
    index  = 0
    for line in arrayOfLines:
        line = line.strip()
        listFromLine = line.split('\t')
        returnMat[index, :] = listFromLine[0:3]
        classLabelVector.append(int(listFromLine[-1]))
        index +=1
    return returnMat, classLabelVector


def main():
    #group, labels = createDataSet()
    #print(classify0([-8,-8], group, labels, 3))
    datingDataMat, datingLabels = file2matrix("datingTestSet2.txt")
    print("datingDataMat={0}".format(datingDataMat))
    print("datingLabels={0}".format(datingLabels))

if __name__ == "__main__":
    main()
