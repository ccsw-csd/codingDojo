import { ChildrenResponse } from './utils/children-response.enum';
import { Item } from './utils/item.enum';

export default class TrickOrTreat {
  private static readonly MIN_CANDY_PER_PACK = 2;

  private constructor() { }

  public static evaluate(nChildren: number, packs: Array<Array<string>>): ChildrenResponse {
    if (nChildren !== packs.length) {
      return ChildrenResponse.TrickOrTreat;
    }

    let packSummaries: Array<PackSummary>;

    try {
      packSummaries = packs.map(it => new PackSummary(it));
    } catch (e) {
      return e.message;
    }

    if (packSummaries.some(it => it.candy < TrickOrTreat.MIN_CANDY_PER_PACK)) {
      return ChildrenResponse.TrickOrTreat;
    }

    if (packSummaries.some(it => it.candy <= it.fruit)) {
      return ChildrenResponse.TrickOrTreat;
    }

    if (packSummaries.some(it => it.candy !== packSummaries[0].candy)) {
      return ChildrenResponse.TrickOrTreat;
    }

    return ChildrenResponse.Thanks;
  }
}

class PackSummary {
  public candy: number;
  public fruit: number;

  constructor(pack: Array<string>) {
    if (pack.includes(Item.Khaki)) {
      throw new Error(ChildrenResponse.KhakiFound);
    }

    this.candy = pack.filter(it => it === Item.Candy).length;
    this.fruit = pack.length - this.candy;
  }
}