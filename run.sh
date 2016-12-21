#!/bin/sh

export LD_LIBRARY_PATH="/informatik2/nats/home/salama/workspace/RGB2:${LD_LIBRARY_PATH}:."

type="lab"
args=$1
runid=$2
#shift
#shift

 ln -s $args.train.$type data/$args.train.$type.$runid
 ln -s $args.test.$type data/$args.test.$type.$runid

#	java -classpath "bin:lib/trove.jar" -Xmx20000m parser.DependencyParser model-file:runs/$args.model.$type.$runid train train-file:data/$args.train.$type.$runid unimap-file:unimap/$args.uni.map test test-file:data/$args.test.$type.$runid $@ | tee runs/$args.$type.$runid.log
	java -classpath "bin:lib/trove.jar" -Xmx20000m parser.DependencyParser model-file:talbanken05_train.conll.model  train train-file:/informatik2/nats/home/salama/workspace/RGB2/examples/data/swedish.uni.talbanken05_train.conll model:basic 
	
	

    rm data/$args.train.$type.$runid
    rm data/$args.test.$type.$runid
	#rm data/$args/$args.$type.model

