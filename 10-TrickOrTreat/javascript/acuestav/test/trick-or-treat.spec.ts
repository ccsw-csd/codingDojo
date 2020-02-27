import TrickOrTreat from '../src/trick-or-treat';
import { ChildrenResponse } from '../src/utils/children-response.enum';
import { Item } from '../src/utils/item.enum';

describe('trick or treat', function () {
  const basicPack = [Item.Candy, Item.Candy];

  it('should have one pack per child', function () {
    expect(TrickOrTreat.evaluate(3, [basicPack, basicPack, basicPack]))
      .toEqual(ChildrenResponse.Thanks);

    expect(TrickOrTreat.evaluate(3, [basicPack, basicPack]))
      .toEqual(ChildrenResponse.TrickOrTreat);
  });

  it('should have at least 2 pieces of candy per pack', function () {
    expect(TrickOrTreat.evaluate(2, [basicPack, basicPack]))
      .toEqual(ChildrenResponse.Thanks);

    expect(TrickOrTreat.evaluate(2, [basicPack, [Item.Candy]]))
      .toEqual(ChildrenResponse.TrickOrTreat);
  });

  it('should have more candy than fruit in every pack', function () {
    expect(TrickOrTreat.evaluate(2, [basicPack, [Item.Candy, Item.Candy, 'banana']]))
      .toEqual(ChildrenResponse.Thanks);

    expect(TrickOrTreat.evaluate(2, [basicPack, [Item.Candy, Item.Candy, 'orange', 'pear']]))
      .toEqual(ChildrenResponse.TrickOrTreat);
  });

  it('should have same amount of candy in every pack', function () {
    expect(TrickOrTreat.evaluate(2, [[Item.Candy, Item.Candy, Item.Candy], [Item.Candy, Item.Candy, Item.Candy]]))
      .toEqual(ChildrenResponse.Thanks);

    expect(TrickOrTreat.evaluate(2, [[Item.Candy, Item.Candy, Item.Candy], [Item.Candy, Item.Candy]]))
      .toEqual(ChildrenResponse.TrickOrTreat);
  });

  it('should not have khakis', function () {
    expect(TrickOrTreat.evaluate(1, [[Item.Candy, Item.Candy, Item.Candy, 'apple', 'kiwi']]))
      .toEqual(ChildrenResponse.Thanks);

    expect(TrickOrTreat.evaluate(1, [[Item.Candy, Item.Candy, Item.Khaki]]))
      .toEqual(ChildrenResponse.KhakiFound);
  });

});