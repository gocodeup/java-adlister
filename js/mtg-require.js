
const mtg = require('mtgsdk');

mtg.card.find(3)
	.then(result => {
		console.log(result.card.name)
	});

// card.where({name: 'Squee'}).on('data', card => {console.log(card.name)})
